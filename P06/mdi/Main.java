package mdi;

import moes.Moes;
import product.Media;
import customer.Student;

import java.io.BufferedWriter;
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
    private static final String fileVersion = "1.0";
    private String filename;

    public Main(){
        moes =new Moes();
        menu= new Menu();67  
        running=true;

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
        System.out.println("Enter a Student's name: ");
        String name= scanner.nextLine();
        System.out.print("Enter valid student id: ");
        int id= scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter valid student email: ");
        String email= scanner.nextLine();
        System.out.print("Do you want Unlimited Account? (yes/no): ");
        boolean Unlimited= scanner.nextLine().equalsIgnoreCase("yes");

        Student student= new Student(name, id, email, Unlimited);
        moes.addStudent(student);
        System.out.println("Student added.");
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

        Media media= new Media(title, url, points);
        moes.addMedia(media);
        System.out.println("Added Media");
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(magicCookie + "\n");
            bw.write(fileVersion + "\n");
            moes.save(bw);
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
    
    //Ending the Application
    private void endApp() {
        System.out.println("Exiting application...Thank you for Visiting!");
        running = false;
    }
    }
    


