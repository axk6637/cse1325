package customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;
/**
 * Represents an alacarte student account in the MOES System.
 * Subclass of the Account superclass. Manages the points to access media.
 * 
 * @author Aashreeya Karmacharya
 * @version 0.2
 * @since 2024
 */

public class Alacarte extends Account{
    //private field
    private int pointsRemaining;
/**
 * Adds points to the Alacarte account.
 * 
 * @param points
 * @since 2024
 */

    public Alacarte(BufferedReader br) throws IOException {
        super(br);  // Call the superclass constructor to read accountNumber
        this.pointsRemaining = Integer.parseInt(br.readLine());  // Read pointsRemaining
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);  // Call the superclass method to save accountNumber
        bw.write(Integer.toString(pointsRemaining) + '\n');  // Save pointsRemaining
    }

    
    //Method 1
    public void buyPoints(int points){
        this.pointsRemaining +=points;
    }

/**
 * Retrieves remaining points in the Alacarte account.
 * 
 * @return The number of points remaining in the Alacarte account.
 * @since 2024
 */
    public int getPointsRemaining(){
        return this.pointsRemaining;
    }
    
/**
 * Plays the requested media if the points are sufficient, if not indicates the additional points required.
 * 
 * @param media The media to be played.
 * @return A message that indicates the media being played or number of points required to play the media.
 * @since 2024 
 */
    @Override
    public String play(Media media){
        int mediaPoints= media.getPoints();// getting points from media instance of class Media
        if (pointsRemaining>= mediaPoints){
            pointsRemaining -=mediaPoints;
            return "Playing " +media.toString();

        }else{
            return "Buy more points: Requires " +mediaPoints + " points, you have "  + pointsRemaining ;
        }
    }

}