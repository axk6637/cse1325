public class Purse {

     //Array of Coin containing 5 coins with Coin object and dates
    public static void main(String[] args){
        Coin[] purse={
            new Coin(Denomination.PENNY, 1924),
            new Coin(Denomination.NICKEL, 1945),
            new Coin(Denomination.DIME, 1990),
            new Coin(Denomination.QUARTER, 2010),
            new Coin(Denomination.DIME, 1988),
    
        };
    
        double totalValue= 0.0;
        int earliestYear= Integer.MAX_VALUE;
        int latestYear = Integer.MIN_VALUE;
        

        //for-loop
        for (Coin coin: purse){
            totalValue +=coin.getValue();
            System.out.println(coin);
            int year =coin.getYear();
    
            if (year < earliestYear){
                earliestYear =year;
            }
            if (year> latestYear){
                latestYear= year;
            }
        }
    
        // Print Statements
    
        System.out.printf("The total value of the coins in the purse is $%.2f!\n", totalValue);
        System.out.println("The coins are from the year: " + earliestYear + " to " + latestYear + "!");
    
    }
}

