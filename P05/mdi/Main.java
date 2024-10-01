package mdi;

import moes.Moes;
import product.Media;
import customer.Student;
import java.util.Scanner;

public class Main {
    private Moes moes;
    private Menu menu;
    private String output;
    private boolean running;
    private Scanner scanner=new Scanner(System.in);

    public Main(){
        moes =new Moes();
        menu= new Menu();
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
        
    }

    //static main field
    public static void main(String[] args){
        Main main= new Main();
        main.mdi();
    }

    //Main loop : Displays the menu to the user and runs the item selected by the user
    public void mdi(){
        System.out.println("Welconme to Mavs Online Entertainment System (MOES)!!");
        
        while(running){
            System.out.println(menu);
            System.out.println("Make a selection: ");
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
        System.out.println("Enter Student number");
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
        System.out.print("Enter media index: ");
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

    //Method to List Available points for Student
    private void buyPoints(){
        listStudents();
        System.out.print("Enter Student index: ");
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
    





    }


