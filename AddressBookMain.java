package AddressBookByCollection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddressBookMain {
    static public ArrayList<Contacts> contactList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static Map<String, Contacts> nameHashMap = new HashMap<>();
    public static Map<String, Contacts> cityHashMap = new HashMap<>();
    public static Map<String, Contacts> stateHashMap = new HashMap<>();

    public static void viewByOption(Map<String, AddressBookMain> map) {
        System.out.println("Enter you choice \n1.view by name \n2. view by city \n3.view by state \n4.back");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                viewByName(nameHashMap);
                break;
            case 2:
                viewByCity(cityHashMap);
                break;
            case 3:
                viewByState(stateHashMap);
                break;
            case 4:
                return;
            default:
                System.out.println("Please enter a valid choice");
        }
    }

    public static void countByOption() {

        System.out.println("1. Count City ");
        System.out.println("2. Count State");
        System.out.println("3. Back ");
        System.out.println("Enter Your Choice : ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                Map<String, Long> countCity = contactList.stream()
                        .collect(Collectors.groupingBy(Contacts::getCity, Collectors.counting()));
                System.out.println(countCity + "\n");
                break;
            case 2:
                Map<String, Long> countState = contactList.stream()
                        .collect(Collectors.groupingBy(Contacts::getState, Collectors.counting()));
                System.out.println(countState + "\n");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Option");
        }
    }

    public boolean addContact(Contacts contact) {
        List<Contacts> checkByName = searchByName(contact.getFirstName());
        for (Contacts equalName : checkByName)
            if (equalName.equals(contact))
                return false;
        contactList.add(contact);
        return true;
    }

    // method for search contact by name
    public List<Contacts> searchByName(String name) {
        // stream and lambda for find filter given name from arraylist
        return contactList.stream().filter(person -> person.getFirstName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Contacts> searchByCity(String city) {
        return contactList.stream().filter(person -> person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Contacts> searchByState(String state) {
        return contactList.stream().filter(person -> person.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    //method to view person
    public static void viewByName(Map<String, Contacts> nameHashMap) {
        nameHashMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "=" + e.getValue().toString()));
    }

    public static void viewByCity(Map<String, Contacts> cityHashMap) {
        cityHashMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "=" + e.getValue().toString()));
    }

    public static void viewByState(Map<String, Contacts> stateHashMap) {
        stateHashMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "=" + e.getValue().toString()));
    }

    public static List<Contacts> sortBy(Function<? super Contacts, ? extends String> key) {
        return contactList.stream().sorted(Comparator.comparing(key)).collect(Collectors.toList());
    }

    public static List<Contacts> sortByZip(Function<? super Contacts, ? extends Long> key) {
        return contactList.stream().sorted(Comparator.comparing(key)).collect(Collectors.toList());
    }


    // method for edit contact
    public boolean editContact(Contacts current, Contacts edit) {
        if (!contactList.contains(current))
            return false;
        contactList.remove(current);
        contactList.add(edit);
        return true;
    }

    // method for delete contact
    public boolean deleteContact(Contacts contacts) {
        contactList.remove(contacts);
        return true;
    }

    // for showing output details
    @Override
    public String toString() {
        if (contactList.isEmpty())
            return "No contacts found!";
        String result = "";
        for (int i = 0; i < contactList.size(); i++) {
            result += " " + contactList.get(i);
        }
        return result;
    }

    // method for adding details
    public static Contacts readContact() {
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter State: ");
        String state = sc.nextLine();
        System.out.print("Enter Zip Code: ");
        Long zip = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Phone Number: ");
        Long phoneNum = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Email ID: ");
        String email = sc.nextLine();
        return new Contacts(firstName, lastName, address, city, state, email, zip, phoneNum);
    }

    // method for show option for contacts
    public static void addressBookOptions(AddressBookMain addressBook) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nAddress Book Contact Options");
            System.out.println("1. Add contact details");
            System.out.println("2. Edit contact details");
            System.out.println("3. Delete contact details");
            System.out.println("4. Show contacts details");
            System.out.println("5. Sort Address Book");
            System.out.println("6. Back to main menu");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    if (addressBook.addContact(readContact())) // call add contact with passing method read contact
                        System.out.println("Contact Added Successfully");
                    else
                        System.out.println("Contact Already Exists");
                    break;
                case 2:
                    System.out.println("Enter First name to edit contact: ");
                    String name = sc.nextLine();
                    List<Contacts> equalName = addressBook.searchByName(name);// list of equal first name
                    if (equalName.isEmpty())// if not match found
                        System.out.println("List Empty!!!");
                    else if (equalName.size() == 1) {// if only one equal match found
                        addressBook.editContact(equalName.get(0), readContact()); // call edit method
                        System.out.println("Contact data modified");
                    } else {// if more than one firstname match found in equal name list
                        equalName.forEach(i -> System.out.println(equalName.indexOf(i) + "  " + i.toString()));
                        System.out.println("Enter index to edit : ");
                        int i = sc.nextInt();
                        sc.nextLine();
                        addressBook.editContact(equalName.get(i), readContact());
                        System.out.println("Contact Modified");
                    }
                    break;
                case 3:
                    System.out.println("Enter First name to delete contact: ");
                    name = sc.nextLine();
                    equalName = addressBook.searchByName(name);
                    if (equalName.isEmpty())
                        System.out.println("List Empty!!!");
                    else if (equalName.size() == 1) {
                        addressBook.deleteContact(equalName.get(0));
                        System.out.println("Contact deleted");
                    } else {
                        equalName.forEach(x -> System.out.println(equalName.indexOf(x) + "  " + x.toString()));
                        System.out.println("Enter an index to delete");
                        int index = sc.nextInt();
                        sc.nextLine();
                        addressBook.deleteContact(equalName.get(index));
                        System.out.println("Contact deleted");
                    }
                    break;
                case 4:
                    System.out.println(addressBook.toString());
                    break;
                case 5:
                    sortByOption();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }

    public void searchByOptions() {
        AddressBookMain addressBook = new AddressBookMain();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. By name");
        System.out.println("2. By city");
        System.out.println("3. By state");
        System.out.println("4. Back");
        System.out.println("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                contactList.forEach(book -> searchByName(name).forEach(System.out::println));
                break;
            case 2:
                System.out.println("Enter city: ");
                String city = sc.nextLine();
                contactList.forEach(book -> searchByCity(city).forEach(System.out::println));
                break;
            case 3:
                System.out.println("Enter state: ");
                String state = sc.nextLine();
                contactList.forEach(book -> searchByState(state).forEach(System.out::println));
                break;
            case 4:
                return;
            default:
                System.out.println("Please Enter a Valid Choice");
        }

    }

    public static void sortByOption() {
        System.out.println("Choose how you want to sort 1. first name 2. last name 3.city 4.state 5.zip");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                AddressBookMain.sortBy(Contacts::getFirstName).forEach(System.out::println);
                break;
            case 2:
                AddressBookMain.sortBy(Contacts::getLastName).forEach(System.out::println);
                break;
            case 3:
                AddressBookMain.sortBy(Contacts::getCity).forEach(System.out::println);
                break;
            case 4:
                AddressBookMain.sortBy(Contacts::getState).forEach(System.out::println);
                break;
            case 5:
                AddressBookMain.sortByZip(Contacts::getZip).forEach(System.out::println);
                break;
            default:
                System.out.println("Please enter a valid choice");
        }
    }

}
