import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class contactManager {

    public static int Menu() throws IOException {
        Scanner input = new Scanner(System.in);
        //Displays Menu
        System.out.println(1 + "." + " View contacts.");
        System.out.println(2 + "." + " Add a new contact.");
        System.out.println(3 + "." + " Search a contact by name.");
        System.out.println(4 + "." + " Delete an existing contact.");
        System.out.println(5 + " Exit.");
        System.out.println("Enter an option (1, 2, 3, 4, or 5)");
        int Choice = input.nextInt();
        //Functionality for navigating around the menu
        if (Choice == 1) {
            viewContacts();
            System.out.println("Would you like to do something else? If so enter another option!");
        } else if (Choice == 2) {
            addContact();
        } else if (Choice == 3) {
            Search();
        } else if (Choice == 4) {
            delete();
        } else if (Choice == 5) {
            System.out.println("Goodbye");
            System.exit(0);
        }
        return Menu();
    }

    //Display of contacts
    public static boolean viewContacts() throws IOException {
        Path contactsPath = Paths.get("src", "contacts.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < contactsList.size(); i++) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }
        return false;
    }

    //add a contact
    public static void addContact() throws IOException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the contacts first name?");
        String firstName = userInput.nextLine();
        System.out.println("What is the contacts last name?");
        String lastName = userInput.nextLine();
        System.out.println("Enter this contacts number");
        String PhoneNumber = userInput.nextLine();
        Files.write(
                Paths.get("src", "contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + PhoneNumber),
                StandardOpenOption.APPEND);
    }

        //Search a contact
        public static void Search() throws IOException {
            Scanner Search = new Scanner(System.in);
            System.out.println("who would like to search");
            String search = Search.nextLine();
            List<String> lines = Files.readAllLines(Paths.get("src", "contacts.txt"));
            for (String line : lines) {
                if (line.contains(search)) {
                    System.out.println(line);
                }
            }
        }

    //Delete a contact
    public static void delete() throws IOException {
        Scanner delete = new Scanner(System.in);
        System.out.println("who would like to delete");
        String Choice = delete.nextLine();
        List<String> lines = Files.readAllLines(Paths.get("src", "contacts.txt"));
        List<String> newList = new ArrayList<>();
        for (String line : lines) {
            if (line.isEmpty()) {
                System.out.println("Invalid input");
            } else if(line.contains(Choice)) {
                lines.remove(Choice);
                continue;
            }
            newList.add(line);
            Files.write(Paths.get("src", "contacts.txt"), newList);
        }
    }
}