package mdi;

import moes.Moes;
import product.Media;
import customer.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private Moes moes;
    private Menu menu;
    private boolean running;
    private Scanner scanner=new Scanner(System.in);

    //private static fields
    private static final String extension = ".moes";
    private static final String magicCookie = "MOES_MAGIC_COOKIE";
    private static final String fileVersion = "2.0";
    private String filename;
    private boolean dirty;

    public Main(){
        moes =new Moes();
        menu= new Menu(); 
        running=true;
        dirty=false;

        //Adding menu items
        menu.addMenuItem(new MenuItem("Exit", () ->{
            endApp();
        }));
        menu.addMenuItem(new MenuItem("Play Media", () ->{
            playMedia();
        }));
        menu.addMenuItem(new MenuItem("List Media", () ->{
            listMedia();
        }));
        menu.addMenuItem(new MenuItem("List available points", () ->{
            listAvailablePoints();
        }));
        menu.addMenuItem(new MenuItem("Buy Points", () ->{
            buyPoints();
        }));
        menu.addMenuItem(new MenuItem("Add Media", () ->{
            addMedia();
        }));
        menu.addMenuItem(new MenuItem("List all students", () ->{
            listStudents();
        }));
        menu.addMenuItem(new MenuItem("Add a student", () ->{
            addStudent();
        }));
        menu.addMenuItem(new MenuItem("Save to file", () -> {
            save();
        }));
        menu.addMenuItem(new MenuItem("Save as new file", () -> {
            saveAs();
        }));
        menu.addMenuItem(new MenuItem("Open file", () -> {
            open();
        }));
        menu.addMenuItem(new MenuItem("New MOES", () -> {
            newMoes();
        }));
    }

    //static main field
    public static void main(String[] args){
        Main main= new Main();
        main.mdi();
    }

    //Method to display a title
    private void moesTitle(){
        String title= """
                 \\\\\\///
                  (@@)
     ._________o00-(_)-00o_________.
     |                             |
     |  MAVS ONLINE ENTERTAINMENT  |
     |            SYSTEM           |
     |            (MOES)           |
     |         Version 2.0         |
     | @2024 Aashreeya Karmacharya |
     |_____________________________| 
                """;
        System.out.println(title);
    }

    //Main loop : Displays the menu 0to the user and runs the item selected by the user
    private void mdi(){
        System.out.println("Welcome to Mavs Online Entertainment System (MOES)!!");
        moesTitle(); //Display the banner/title

        while(running){
            System.out.println(menu);
            System.out.print("Make a selection: ");
            int select=scanner.nextInt();
            scanner.nextLine();
            menu.run(select);
        }
    }

    //Method to add student
    private void addStudent(){
        System.out.print("Enter a Student's name: ");
        String name= scanner.nextLine();
        System.out.print("Enter valid student id: ");
        int id= scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter valid student email: ");
        String email= scanner.nextLine();
        System.out.print("Do you want Unlimited Account? (yes/no): ");
        boolean Unlimited= scanner.nextLine().equalsIgnoreCase("yes");
        try{
            Student student= new Student(name, id, email, Unlimited);
            moes.addStudent(student);
            dirty=true;
            System.out.println("Student added.");
        }catch (IllegalArgumentException e) {
            System.err.println( "Error occured: " + e.getMessage());
        }
        
    }

    //Method to List all Students
    private void listStudents(){
        String studentList= moes.getStudentList();
        System.out.println(studentList);
    }

    //Method to Add Media
    private void addMedia(){
        System.out.print("Enter media title: ");
        String title= scanner.nextLine();
        System.out.print("Enter URL: ");
        String url= scanner.nextLine();
        System.out.print("Enter points: ");
        int points = scanner.nextInt();
        scanner.nextLine();
        try{
            Media media= new Media(title, url, points);
            moes.addMedia(media);
            dirty=true;
            System.out.println("Added Media");
        }catch (RuntimeException e) {
            System.err.println( "Error occured: " + e.getMessage());
        }
    }

    //Method to List All Media
    private void listMedia(){
        String mediaList= moes.getMediaList();
        System.out.println(mediaList);
    }

    //Method to Play the selected media
    private void playMedia(){
        listStudents();
        System.out.print("Enter student number: ");
        int studentIndex = scanner.nextInt();
        scanner.nextLine();

        //Display the available points for the selected student
        int point= moes.getPoints(studentIndex);
        if(point == Integer.MAX_VALUE){
            System.out.println("UNLIMITED ACCOUNT");
        }else{
            System.out.println("Available Points: "+ point);
     
        }

        //Display the media according to user input
        listMedia();
        System.out.print("Enter media number: ");
        int mediaIndex = scanner.nextInt();
        scanner.nextLine();

        //Play the media
        String resultMedia =moes.playMedia(studentIndex, mediaIndex);
        System.out.println(resultMedia);

        //Display remaning points in Alacarte accounts
        if (point != Integer.MAX_VALUE){
            System.out.println("Remaining points: "+ moes.getPoints(studentIndex));

        }
    }

    //Method to buy points
    private void buyPoints(){
        listStudents();
        System.out.print("Enter Student number: ");
        int studentIndex= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Your Current points: "+ moes.getPoints(studentIndex));
        System.out.print("Enter points to buy: ");
        int morePoints=scanner.nextInt();
        scanner.nextLine();

        if(morePoints>0){
            String result= moes.buyPoints(studentIndex, morePoints);
            System.out.println(result);

        }else{
            System.out.println("Invalid points entered!!");
        }
    }
    //Method to List Available Points for Student
    private void listAvailablePoints() {
        listStudents();
        System.out.print("Enter student number: ");
        int studentIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        int points = moes.getPoints(studentIndex);
        if (points == Integer.MAX_VALUE) {
            System.out.println("Unlimited Account: Infinite points available!");
        } else {
            System.out.println("Available points: " + points);
        }
    }

    private void save() {
        if (filename == null) {
           saveAs();
            return;
        }
        //extreme bonus 1
        //Check if file already exists to create auto backup
        java.io.File saveFile= new java.io.File(filename);
        if (saveFile.exists()){
            java.io.File backupFile = new java.io.File(filename + "~");

            if(!saveFile.renameTo(backupFile)){
                System.err.println("Failed to create backup file");
                return; //backup fail
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(magicCookie + "\n");
            bw.write(fileVersion + "\n");
            moes.save(bw);
            dirty= false;
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.err.println("Failed to save: " + e.getMessage());
        }
    }
     private void saveAs() {
        System.out.println("Current filename: "+ filename);
        System.out.print("Enter a new filename: ");
        String newFilename = scanner.nextLine();
        if (!newFilename.endsWith(extension)) {
            newFilename += extension;
        }
        this.filename = newFilename;
        save();
    }

    // Method to load data from a file
    private void open(){
        if (dirty) {
            boolean notAbort= handleDirty(); 
            if (!notAbort){
                return;
            }
        }

        System.out.println("\nCurrent filename: "+ filename);
        System.out.print("Enter a filename to open: ");
        String newFilename = scanner.nextLine();
        if (!newFilename.endsWith(extension)) {
            newFilename += extension;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(newFilename))) {
            String cookie = br.readLine();
            if (!magicCookie.equals(cookie)) {
                throw new IOException("Invalid file format: Magic Cookie is mismatched");
            }
            String version = br.readLine();
            if (!fileVersion.equals(version)) {
                throw new IOException("File version is mismatched");
            }
            Moes newMoes = new Moes(br);
            moes = newMoes;
            dirty=false;
            this.filename = newFilename;
            System.out.println("Data successfully loaded from " + filename);
        } catch (IOException e) {
            System.err.println("Failed to open file: " + e.getMessage());
        }
    }

    private boolean handleDirty(){
        System.out.println("\nWarning: You have not saved your changes. You might lose all your data. Choose what to do!");
        System.out.println("1). Save your changes to the current file.");
        System.out.println("2). Save changes to a new file.");
        System.out.println("3). Discard all changes.");
        System.out.println("4). Abort Operation. Return to Selection Page.\n");

        System.out.print("Enter your option: ");
        int option=scanner.nextInt();
        scanner.nextLine();

        //using switch case to operate as per user input
        switch (option){
            case 1:
                save(); //Save to current file
                return true;

            case 2:
                saveAs();
                return true;

            case 3:
                System.out.println("Discarded");
                return true;

            case 4:
                System.out.println("\nOperation is aborted..Going Back to Selection Page..\n\n");
                return false;

            default:
            System.out.println("Option Invalid. Please Try Again:(\n\n") ;
            return handleDirty();

        }
    }

// Create a new MOES system
private void newMoes() {
    boolean notAbort=true;
    if(dirty){
        notAbort= handleDirty();  // Check if there are unsaved changes
    }
    if (!notAbort){
        return;
    }
    
    moes = new Moes();
    filename = null;
    dirty=false;
    System.out.println("New MOES system created.");
}

    //Ending the Application
    private void endApp() {
        System.out.println("Exiting application...Thank you for Visiting!");
        running = false;
    }
    }
    


