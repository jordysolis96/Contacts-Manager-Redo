import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;



public class contactManager {

    public static int Menu(){
        Scanner input =  new Scanner(System.in);
        System.out.println(1 + "." + " View contacts.");
        System.out.println(2 + "." + " Add a new contact.");
        System.out.println(3 + "." + " Search a contact by name.");
        System.out.println(4 + "." + " Delete an existing contact.");
        System.out.println(5 + " Exit.");
        System.out.println("Enter an option (1, 2, 3, 4, or 5)");
        int Choice = input.nextInt();

        return Choice;
    }

    public static void viewContacts(){
        Path contactsPath = Paths.get("data", "contacts.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);

        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }
    }
}
