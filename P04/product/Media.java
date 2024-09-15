package product;

public class Media{

    //Private fields
    private String title;
    private String url;
    private int points;


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
        return title + " (" + url + ", "+ points + " points" + ")";

    }

}