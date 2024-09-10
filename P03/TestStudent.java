public class TestStudent{
    public static void main(String[] args) {
        int totalErrors=0; 
        //1st vector test
        try{
            Student student1 = new Student("Prof Rice", 1234567, "george.rice@uta.edu");
            String actualString = student1.toString();
            String expectedStringStart = "Prof Rice(1234567,george.rice@uta.edu, Account #";
            
            if(actualString.startsWith(expectedStringStart)==false || actualString.endsWith(")")==false){
                throw new IllegalArgumentException("FAIL! The toString() method returned incorrect representation of object");
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(-1);
            totalErrors++;
       }

       // 2nd Vector test for non-UTA emails
       try{
        Student student2= new Student("Bill Gates", 123, "bill@gmail.com");

        //Condition 1: Report as an error if NO exception being thrown
        throw new IllegalArgumentException("Expected IllegalArgumentException but not thrown");
        }catch (IllegalArgumentException e){

        //Catch and ignore the correct exception
        String expectedMessage = "Non-UTA email address: bill@gmail.com";
        if(!e.getMessage().equals(expectedMessage)){

            //Report as an error any other exception message
            System.err.println("FAIL! Incorrect exception messgae: "+ e.getMessage());
            System.exit(-1);
            totalErrors++;
        }
        }catch (Exception e){

        //Report as an error any other exception
        System.err.println("FAIL! Unexpected exception type: "+ e.getClass().getName());
        System.exit(-1);
        totalErrors++;
    }

    
    }
}

