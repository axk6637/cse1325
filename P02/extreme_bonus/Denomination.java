public enum Denomination { PENNY(0.01), NICKEL(0.05), DIME(0.10), QUARTER(0.25);

    //private field
    private double value;

    //private constructor
    private Denomination(double value){
        this.value=value;
    
    }

    //Method
    public double getValue(){
        return this.value;
    }

   //Override 
   @Override
   public String toString(){
    return this.name().toLowerCase();
    }
}