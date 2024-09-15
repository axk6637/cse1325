package product;

/**
 * Represents a piece of media with a title, URL, and points required to access the media
 * 
 * @author Student
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
    //Method
    public Media(String title, String url, int points){
        this.title=title;
        this.url=url;
        this.points= points;
    }
    public int getPoints(){
        return points;
    }


    //Overrride
    @Override
    public String toString(){
        return title + " (" + url  + ", "+ points + ")";

    }

}