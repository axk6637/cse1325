package customer;
import product.Media;

public abstract class Account{
    // private fields

    private int accountNumber;
    private static int nextAccountNumber =1;

    //Method 1 
    public Account(){
        this.accountNumber = nextAccountNumber++;
    }

    //Method 2
    public int getAccountNumber(){
        return accountNumber;
    }

    //Method 3
    public abstract String play(Media media);
}
