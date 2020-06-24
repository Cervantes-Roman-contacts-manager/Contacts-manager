import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactList {
    static Scanner input = new Scanner(System.in);
    static Scanner scanner = new Scanner(System.in);
    static List<People> person;
    static List<String> contacts;
    static int choice;
    static Path contact = Paths.get("contacts-manager-exercise/src", "contacts.txt");


    // this is the method to Display the list of people
    public static void listPeople(List<People> person) {
        try {
            contacts = Files.readAllLines(contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
        person = People.nameStringsToPeople(contacts);
        for (People people : person) {
            System.out.printf("%s%n", people.getName());
        }
    }

    // this is the method to add people
    public static void addPeople() {
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        String[] arr = name.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1)).append(" ");
        }
        System.out.println("Please enter number");
        String phoneNumber = scanner.nextLine();
        String info = sb + " | " + phoneNumber;

        try {
            Files.write(
                    Paths.get("contacts-manager-exercise/src", "contacts.txt"),
                    Collections.singletonList(info), // list with one item
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        listPeople(person);
    }

    public static void searchName() {
        System.out.println("Please enter the name of person to search for: ");
        String searchedName = scanner.nextLine();
        try {
            contacts = Files.readAllLines(contact);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String singleName : contacts) {

            if (singleName.contains(searchedName)) {
                System.out.printf("Here is the info for : %s%n", searchedName);
                System.out.println(singleName);
            }
        }
    }

    public static void deleteByName() {
        System.out.println("Please enter the name of person to delete: ");
        String name = scanner.nextLine();
        try {
            contacts = Files.readAllLines(contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String toBeRemoved = "";

        for (String singleName : contacts) {
            if (singleName.contains(name)) {
                toBeRemoved = singleName;
                System.out.println(name + " Has been removed.");
            }
        }
        contacts.remove(toBeRemoved);
        try {
            Files.write(contact, contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(contacts);
    }

    // this is the method to make a selection
//    public static void selection() {
//        choice = input.nextInt();
//        if (choice == 1) {
//            listPeople(person);
//        }
//        if (choice == 2) {
//            addPeople();
//        }
//        if (choice == 3) {
//            searchName();
//        }
//        if (choice == 4) {
//            deleteByName();
//        }
//        if (choice == 5) {
//            return;
//        }
//        System.out.println("Thank you, now exiting program.");
//    }

    public static void selection() {
        choice = input.nextInt();
        boolean yesNo = false;
        while(!yesNo){
            switch (choice) {
                case 1:
                        listPeople(person);
                    break;
                case 2:
                    addPeople();
                    break;
                case 3:
                    searchName();
                    break;
                case 4:
                    deleteByName();
                    break;
                case 5:
                    yesNo = true;
            }
        }
    }
//    switch(input){
//        case:1
//    }
//    break;
//    case:2 method();
//    break;
//    case:3 method();

    public static void main(String[] args) {
        System.out.println("1. View contacts. \n2. Add a new contact. \n3. Search a contact by name. \n4. Delete an existing contact. \n5. Exit. ");
        System.out.print("Please select an option from above: ");
        selection();
    }
}

