package moes;
import customer.Student;
import product.Media;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The Moes class manages ArrayLists of Student and Media objects like adding students and media, handling points, playing media.
 * 
 * @author Aashreeya Karmacharya
 * @version 0.2
 * @since 2024
 */
public class Moes {
    private ArrayList<Media> library = new ArrayList<>();//media objects
    private ArrayList<Student> customers= new ArrayList<>();//stduent objects

    public Moes() {
        this.library = new ArrayList<>();  // Initialize an empty library
        this.customers = new ArrayList<>();  // Initialize an empty customers list
    }
    
/**
 * Adds a Media object to the library
 * 
 * @param media The Media object to be added.
 * @since 2024
 */

public void addMedia(Media media){
    library.add(media);
}
/**
 *Adds a Student object to the customers list.
 * 
 * @param student The student object to be added.
 * @since 2024
 */

public void addStudent(Student student){
    customers.add(student);
}
/**
 * Returns the formatted list of stduent objects in the customers list.
 * 
 * @return A string representation of the student list which is formatted like a menu.
 * @since 2024
 */
public String getStudentList(){
    StringBuilder studentList= new StringBuilder();

    for (int i=0; i<customers.size(); i++){
        Student student= customers.get(i);
        studentList.append(i).append(") ").append(student.toString()).append("\n");
    }
    return studentList.toString();
}

/**
 * Returns the formatted list of media objects in the media list.
 * 
 * @return A string representation of the media list which is formatted like a menu.
 * @since 2024
 */
public String getMediaList(){
    StringBuilder mediaList = new StringBuilder();

    for (int i=0; i<library.size(); i++){
        Media media = library.get(i);
        mediaList.append(i).append(") ").append(media.toString()).append("\n");
    }
    return mediaList.toString();//converting the StringBuilder to String
    }

/**
 * Obtains the points for the selected student based on their account type.
 * @param studentIndex The index of student in the customers list.
 * @return The points remaining for Alacarte accounts or Max value of integer for Unlimited accounts.
 * @since 2024
 */
public int getPoints(int studentIndex){
    Student student= customers.get(studentIndex);
    Account account = student.getAccount();

    if(account instanceof Alacarte){
        return ((Alacarte)account).getPointsRemaining();
    }else if(account instanceof Unlimited){
        return Integer.MAX_VALUE;
    }else{
        throw new UnsupportedOperationException("Unknown sublclass of Account");
    }
}

/**
 * Buys points for the selected student based on the account type.
 * @param studentIndex The index of student in the customers list.
 * @param points The number of points to buy.
 * @return A message that indicates the result after buying points, remaining points if Alacarte account, no additional points needed if Unlimited account.
 * @since 2024
 */
public String buyPoints(int studentIndex, int points){
    Student student = customers.get(studentIndex);
    Account account = student.getAccount();

    if(account instanceof Alacarte){
        Alacarte alacarteAccount = (Alacarte) account;
        alacarteAccount.buyPoints(points);
        return "Student now has " +alacarteAccount.getPointsRemaining();

    }else if (account instanceof Unlimited){
        return "Student has an unlimited account and needs no additions points.";
    }else{
        throw new UnsupportedOperationException("Unknown subclass of Account");
    }

}

/**
 * Plays the selected media for the selected student/
 * 
 * @param studentIndex The index of student in the customers list.
 * @param mediaIndex The index of media in the library list.
 * @return A message that indicates the result after playing media.
 * @since 2024
 */

public String playMedia(int studentIndex, int mediaIndex){
    Student student= customers.get(studentIndex);
    Media media= library.get(mediaIndex);
    return student.requestMedia(media);
    }
public void save(BufferedWriter bw) throws IOException {
    // Save the size of the media list
    bw.write(Integer.toString(library.size()) + '\n');
    // Call each object's save method by iterating
    for (Media media : library) {
        media.save(bw);
    }

    //saving the size of the students list
    bw.write(Integer.toString(customers.size()) + '\n');
    // Save each student object
    for (Student student : customers) {
        student.save(bw);
    }
}
public Moes(BufferedReader br) throws IOException {
        // Load the size of the media list
        int mediaSize = Integer.parseInt(br.readLine());
        library = new ArrayList<>();
        for (int i = 0; i < mediaSize; i++) {
            library.add(new Media(br));
        }

        // Load the size of the students list
        int studentSize = Integer.parseInt(br.readLine());
        customers = new ArrayList<>();
        for (int i = 0; i < studentSize; i++) {
            customers.add(new Student(br));
        }
    }


 }


