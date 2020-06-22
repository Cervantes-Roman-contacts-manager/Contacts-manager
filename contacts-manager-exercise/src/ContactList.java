import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactList {



    public static void main(String[] args){

        Path contact = Paths.get("contacts-manager-exercise/src", "contacts.txt");
        //System.out.println(Files.exists(contact));

        List<People> person;
        List<String> contacts = new ArrayList<>();

        try {
            contacts = Files.readAllLines(contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(contacts);

    person = People.nameStringsToPeople(contacts);

    listPeople(person);

    for(int i = 0; i < person.size(); i++){
        System.out.println("test");
    }


    }

    public static void listPeople(List<People> person) {
        for (People people : person) {
            System.out.printf("%s%n", people.getName());
        }
    }


}
