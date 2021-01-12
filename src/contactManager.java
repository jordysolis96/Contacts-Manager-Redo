import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class contactManager {

    private String firstName;
    private String lastName;
    private String PhoneNumber;

    public static int Menu() throws IOException {
        Scanner input =  new Scanner(System.in);
        //Displays Menu
        System.out.println(1 + "." + " View contacts.");
        System.out.println(2 + "." + " Add a new contact.");
        System.out.println(3 + "." + " Search a contact by name.");
        System.out.println(4 + "." + " Delete an existing contact.");
        System.out.println(5 + " Exit.");
        System.out.println("Enter an option (1, 2, 3, 4, or 5)");
        int Choice = input.nextInt();
        //Functionality for navigating around the menu
        if(Choice == 1){
            viewContacts();
            System.out.println("Would you like to do something else? If so enter another option!");
        }else if(Choice == 2){
            addContact();
        }else if(Choice == 3){
//            Search();
        }else if(Choice == 4){
            delete();
        }else if(Choice == 5){
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
        for (int i = 0; i < contactsList.size(); i ++) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }
        return false;
    }

    public void info(String firstName, String lastName, String PhoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.PhoneNumber = PhoneNumber;
    }

    public String ContactFormat(){
        return this.firstName + " " + this.lastName + " | " + this.PhoneNumber;
    }

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

//        public static void Search() throws IOException {
//            Scanner search = new Scanner(System.in);
//            String Search = search.nextLine();
//            Path contactsPath = Paths.get("data", "contacts.txt");
//            List<String> contactsList = Files.readAllLines(contactsPath);
//
//            for (String contact : contactsList) {
//                if(contactsList.contains(Search)){
//                    System.out.println(viewContacts());
//                }
//            }
//        }

//        public static void delete() throws IOException {
//        Scanner delete = new Scanner(System.in);
//            System.out.println("Who would you like to delete");
//            String Choice = delete.nextLine();
//            List<String> L = Files.readAllLines(Paths.get("src", "contacts.txt"));
//            List<String> updatedList = new ArrayList<>();
//            for(String line : L){
//                if(line.toLowerCase().contains(Choice)){
//                    continue;
//                }
//                updatedList.add(line);
//            }
//            Files.write(Paths.get("src", "context.txt"), updatedList);
//        }


        public static void delete() throws IOException {
        Scanner delete = new Scanner(System.in);
            System.out.println("who would like to delete");
            String Choice = delete.nextLine();
           List<String> lines = Files.readAllLines(Paths.get("src", "contacts.txt"));
           List<String> newList = new ArrayList<>();

        for (String line : lines) {
            if (line.contains(Choice)) {
            lines.remove(Choice);
            continue;
    }
         newList.add(line);
}

Files.write(Paths.get("src", "contacts.txt"), newList);
        }


//    Scanner Search = new Scanner(System.in);
//            System.out.println("who would like to search");
//    String search = Search.nextLine();
//    List<String> lines = Files.readAllLines(Paths.get("data", "contacts.txt"));
//    List<String> newList = new ArrayList<>();
//
//for (String line : lines) {
//        if (line.equals(search)) {
//            System.out.println(user);
//        }
//        newList.add(line);
//    }
//
//Files.write(Paths.get("data", "contacts.txt"), newList);
}
