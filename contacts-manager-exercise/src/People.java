import java.util.ArrayList;
import java.util.List;

public class People {

    private String name;

    public People(String name){
        this.name = name;
    }

    public  String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public static List<People> nameStringsToPeople(List<String> contacts) {
        List<People> instructors = new ArrayList<>();
        for (String name : contacts) {
            instructors.add(new People(name));
        }
        return instructors;
    }

}
