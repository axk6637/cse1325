public class Coin {
    // Private fields

    private Denomination denomination;
    private int year;

    // Constructor
    public Coin(Denomination denomination, int year){
        this.denomination = denomination;
        this.year= year;
    }

    // Method
    public double getValue(){
        return denomination.getValue();
     }
     
     // Method
     public int getYear(){
         return this.year;
     }

     //Overrride
     public String toString(){
        return year + " " + denomination.toString();
     }

}