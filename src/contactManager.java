import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;
public class contactManager {

    public static int Menu() throws IOException {
        Scanner input =  new Scanner(System.in);
        System.out.println(1 + "." + " View contacts.");
        System.out.println(2 + "." + " Add a new contact.");
        System.out.println(3 + "." + " Search a contact by name.");
        System.out.println(4 + "." + " Delete an existing contact.");
        System.out.println(5 + " Exit.");
        System.out.println("Enter an option (1, 2, 3, 4, or 5)");
        int Choice = input.nextInt();

        if(Choice == 1){
            viewContacts();
            System.out.println("Would you like to do something else? If so enter another option!");
        }else if(Choice == 5){
            System.out.println("Goodbye");
            System.exit(0);
        }
        return Menu();
    }

    public static void viewContacts() throws IOException {
        Path contactsPath = Paths.get("src", "contacts.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }


    }
}
