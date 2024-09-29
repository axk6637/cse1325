package mdi;
import moes.Moes;
import product.Media;
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
        menu.addMenuItem(new MenuItem("Exit", () ->{
            endApp();
        }));
    }

    





    }

}
