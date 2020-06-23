import java.util.ArrayList;
import java.util.List;

public class People {

    private String name;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public People(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public static List<People> nameStringsToPeople(List<String> contacts) {
        List<People> person = new ArrayList<>();
        for (String name : contacts) {
            person.add(new People(name));
        }
        return person;
    }

    public static List<String> peopleToNameStrings(List<People> person) {
        List<String> names = new ArrayList<>();
        for (People i : person) {
            names.add(i.getName());
        }
        return names;
    }

}
