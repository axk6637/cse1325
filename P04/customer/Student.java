package customer;
import product.Media;

/**
 * Represents a student in the MOES system to stote information about the student.
 * 
 * @author Aashreeya Karmacharya
 * @version 0.2  
 * @since 2024
 */
public class Student {

    //private fields
    private String name;
    private int id;
    private String email;
    private Account account;

/** 
 * Constructs a new student with name, ID, and email.
 * Throws exception if not UTA email.
 * 
 * @param name The name of the student.
 * @param id The ID of the student.
 * @param email The email address of the student.
 * @since 2024
 */
    //Constructor 1
    public Student(String name, int id, String email, boolean unlimited){
        if(!email.toLowerCase().endsWith("uta.edu") && !email.toLowerCase().endsWith("@mavs.uta.edu")){
            throw new IllegalArgumentException("Non-UTA email address: "+ email);
        }

        this.name=name;
        this.id=id;
        this.email=email;
        //newly instanced Account
        //this.account= new Account();

        if (unlimited) {
            this.account = new Unlimited();
        } else {
            this.account = new Alacarte();
        }
    
   
    } 
/**
 * Returns the account of the student.
 * @return account of student.
 * @since 2024
 * 
 */
    public Account getAccount(){
        return account;
    }



/**
 * Requests a media object to play through the student's account.
 * 
 * @param media The media to be played.
 * @return A message that indicates the result of playing media.
 * @since 2024
 */
    public String requestMedia(Media media){
        return account.play(media);
    }

/**
 * Returns the string representation of the student with name, id, email, and account number.
 * @since 2024
 */
    //Override
    @Override
    public String toString(){
        return name + "(" + id + ","+ email +"," + " Account #" + account.getAccountNumber() + ")" ;
    }

}
