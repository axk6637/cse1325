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

     //Method
     public double getWeight(){
     switch(denomination){
        case PENNY:
            if (year < 1983){
                return 3.110;
            } 
            else if (year >1984){
                return 2.500;
            }
            else{
                return 0.0;
            }
        case NICKEL:
            return 5.000;
        case DIME:
            if (year <1965) {
                return 2.500;
            }
            else if (year >1966){
                return 2.268;
            }
            else{
                return 0.0;
            }
        case QUARTER:
            if (year <1965){
                return 6.250;
            }
            else if (year > 1966){
                return 5.670;
            }
            else{
                return 0.0;
            }
        default:
            return 0.0;
        }
     }
     

     //Overrride
     @Override
     public String toString() {
        return year + " " + denomination.toString();
     }

}