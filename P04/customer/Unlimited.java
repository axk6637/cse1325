package customer;
import product.Media;

public class Unlimited extends Account {
    //No need to use constructor as java will use the default constructor

    //Override play method from Account
    @Override
    public String play(Media media){
        return "Playing "+ media.toString();
    }
    
}
