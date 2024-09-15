package moes;
import customer.Student;
import product.Media;
import customer.Account;
import customer.Alacarte;
import java.util.ArrayList;

public class Moes {
    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers= new ArrayList<>();

public void addMedia(Media media){
    library.add(media);
}

public void addStudent(Student student){
    customers.add(student);
}

public String getStudentList(){
    StringBuilder studentList= new StringBuilder();

    for (int i=0; i<customers.size(); i++){
        Student student= customers.get(i);
        studentList.append(i).append(") ").append(student.toString()).append(student.toString()).append("\n");
    }
    return studentList.toString();
}

public String getMediaList(){
    StringBuilder mediaList = new StringBuilder();

    for (int i=0; i<library.size(); i++){
        Media media = library.get(i);
        mediaList.append(i).append(") ").append(media.toString()).append("\n");
    }
    return mediaList.toString();//converting the StringBuilder to String
    }

public int getPoints(int studentIndex){
    Student student= customers.get(studentIndex);
    Account account =student.getAccount();

    if(account instanceof Alacarte){
        return ((Alacarte)account).getPointsRemaining();
    }else if(account instanceof Unlimited){
        return Integer.MAX_VALUE;
    }else{
        throw new UnsupportedOperationException("Unknown sublclass of Account");
    }
}
public String buyPoints(int studentIndex, int points){
    Student student = new customers.get(studentIndex);
    Account account = new student.getAccount();

    if(account instanceof Alacarte){

    }
}
    }
}
}

