package customer;

public class Account{
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
    public String play(Media media){
        return "Playing " + media.toString();
        
    }
}
