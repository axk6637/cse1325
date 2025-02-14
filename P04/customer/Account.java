package customer;
import product.Media;
/**
 * Abstract class that represents a student account in the MOES System.
 * Provides methods to change the account number and media access.
 * 
 * @author Aashreeya Karmacharya
 * @version 0.2
 * @since 2024
 */
public abstract class Account{
    // private fields

    private int accountNumber;
    private static int nextAccountNumber =1;

/**
 * Constructs a new Account and assigns a unique account number.
 * 
 * @since 2024
 */
    //Constructor 1 
    public Account(){
        this.accountNumber = nextAccountNumber++;
    }

/**
 * Returns the account number of the student's account.
 * @return The account number.
 * @since 2024
 */

    //Method 1
    public int getAccountNumber(){
        return accountNumber;
    }

/**
 * Abstract method that plays a media object. Subclasses should provide implementation to this method.
 * 
 * @param media The media to be played.
 * @return A message that indicates the result of playing the media.
 * @since 2024
 */

    //Method 2
    public abstract String play(Media media);
}
