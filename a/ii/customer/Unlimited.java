package customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

/**
 * Represents an unlimited student account in the MOES System.
 * Allows unlimited access to media.
 * 
 * @author Aashreeya Karmacharya
 * @version 0.2
 * @since 2024
 */
public class Unlimited extends Account {
    //No need to use constructor as java will use the default constructor
/**
 * Plays a media object.
 * 
 * @param media The media to be played.
 * @return A message that indicates the result of playing the media.
 * @since 2024
 */
    public Unlimited() {
        super();  // Call the Account constructor to set the account number
    }
    
     public Unlimited(BufferedReader br) throws IOException {
        super(br);  // Call the superclass constructor to read accountNumber
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);  // Call the superclass method to save accountNumber
        // No additional fields to save in Unlimited
    }


    //Override play method from Account
    @Override
    public String play(Media media){
        return "Playing "+ media.toString();
    }
    
}
