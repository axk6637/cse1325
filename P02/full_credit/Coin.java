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
        return switch(denomination){
         case PENNY -> 0.01;
         case NICKEL -> 0.05;
         case DIME -> 0.10;
         case QUARTER -> 0.25;
        } ;
     }
     
     // Method
     public int getYear(){
         return this.year;
     }
}