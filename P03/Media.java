public class Media{

    //Private fields
    private String title;
    private String url;

    //Method
    public Media(String title, String url){
        this.title=title;
        this.url=url;
    }

    //Overrride
    @Override
    public String toString(){
        return title + " (" + url + ")";
    }

}