package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Represents a piece of media with a title, URL, and points required to access the media
 * 
 * @author Aashreeya Karmacharya
 * @version 0.2
 * @since 2024
 */
public class Media{

    //Private fields
    private String title;
    private String url;
    private int points;

/**
 * 
 * @param title The title of the Media
 * @param url   The URL of Media
 * @param points The number of points to access the Media
 * 
 */

 public Media(String title, String url, int points) {
    this.title = title;
    this.url = url;
    this.points = points;
} 
    public void save(BufferedWriter bw) throws IOException {
        bw.write(title + '\n');
        bw.write(url + '\n');
        bw.write(Integer.toString(points) + '\n');  // Use Integer.toString to avoid char interpretation
    }

    // Constructor to load data
    public Media(BufferedReader br) throws IOException {
        title = br.readLine();
        url = br.readLine();
        points = Integer.parseInt(br.readLine());
    }
 
    //Method
    //public Media(String title, String url, int points){
        //this.title=title;
       // this.url=url;
        //this.points= points;
    //}
   public int getPoints(){
        return points;
    }


    //Overrride
    @Override
    public String toString(){
        return title + " (" + url  + ", "+ points + ")";

    }

}