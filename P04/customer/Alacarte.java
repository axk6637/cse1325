package customer;
import product.Media;

public class Alacarte extends Account{
    //private field
    private int pointsRemaining;

    //Method 1
    public void buyPoints(int points){
        this.pointsRemaining +=points;
    }
    public int getPointsRemaining(){
        return this.pointsRemaining;
    }

    @Override
    public String play(Media media){
        int mediaPoints= media.getPoints();// getting points from media instance of class Media
        if 
    }

}