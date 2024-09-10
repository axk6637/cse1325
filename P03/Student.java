public class Student {

    //private fields
    private String name;
    private int id;
    private String email;
    private Account account;

    //Method 1
    public Student(String name, int id, String email){
        if(!email.toLowerCase().endsWith("uta.edu") && !email.toLowerCase().endsWith("@mavs.uta.edu")){
            throw new IllegalArgumentException("Non-UTA email address: "+ email);
        }
        this.name=name;
        this.id=id;
        this.email=email;
        //newly instanced Account
        this.account= new Account();
    }   

    public String requestMedia(Media media){
        return account.play(media);
    }

    //Override
    @Override
    public String toString(){
        return name + "(" + id + ","+ email +"," + " Account #" + account.getAccountNumber() + ")" ;
    }

}
