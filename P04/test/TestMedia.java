package test;
import product.Media;

public class TestMedia {
    public static void main(String[] args){
        Media media = new Media("Example Title", "https://example.com");
        String expected= "Example Title (https://example.com)";
        String actual= media.toString();

        if(actual.equals(expected)==false){
            //Display error message
            System.err.println("FAIL! Invalid input. Expected '" + expected + "' but received '" + actual + "'");
            //Return non-zero error code
            System.exit(-1);
        }
    }
        //No output if test vectors pass
}


        
