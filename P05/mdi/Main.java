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
            buyMedia();
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
        boolean inUnlimited= scanner.nextLine().equalsIgnoreCase("yes");

        Student student= new Student(name, id, email, isUnlimited);
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
        String title= scanner.nectLine();
    }



    





    }

}
