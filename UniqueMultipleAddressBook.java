package AddressBookByCollection;

import java.util.*;

public class UniqueMultipleAddressBook {
    Map<String, AddNewContact> addressMap = new HashMap<>();
    List<Contact> contacts = new ArrayList<Contact>();
    Scanner sc = new Scanner(System.in);

    public void addAddress() {
        System.out.println("Enter New Address book name :");
        Scanner sc = new Scanner(System.in);
        String bookname = sc.next();
        if (addressMap.containsKey(bookname)) {
            System.out.println("Address book with given name is exist. Please enter new Name ");
            addAddress();
        } else {
            AddNewContact addNewContact = new AddNewContact();
            addressMap.put(bookname, addNewContact);
            System.out.println("Address Book Successfully Added");
        }
        sc.close();
    }

    /**
     * Method to add contact in address book
     */
    public void addContact() {
        System.out.println("Enter the name of Address book to add the contact.");
        Scanner sc = new Scanner(System.in);
        String newContact = sc.nextLine();
        AddNewContact addContact = addressMap.get(newContact);
        if (addContact == null) {
            System.out.println("No book found");

        } else {
            addressMap.get(newContact).addContact();                         // if present then add it to hashMap
        }
        sc.close();
    }

    /**
     * Method to edit contact in address book
     */
    public void editContact() {
        System.out.println("Enter Name of Contact you want to edit : ");
        Scanner sc = new Scanner(System.in);
        String editName = sc.next();
        if (addressMap.containsKey(editName)) {
            addressMap.get(editName).editContact();                               // calling the edit contact method to edit contacts
        } else {
            System.out.println("Contact doesn't exist, Please enter correct name.");
            editContact();
        }
        sc.close();
    }

    /**
     * Method to delete Contact in address book
     */

    public void deleteContact() {
        System.out.println("Enter Name of Contact you want to delete : ");
        Scanner sc = new Scanner(System.in);
        String bookName = sc.next();
        if (addressMap.containsKey(bookName)) {
            addressMap.get(bookName).deleteContact();                                            // we call the deleteContact function to delete the contact
        } else {
            System.out.println("AddressBook doesn't exist, Please enter correct name.");
            deleteContact();
        }
        sc.close();
    }


    /**
     * Method to delete Address book
     */
    public void deleteAddressBook() {
        System.out.println("Enter Name of Address Book you want to delete: ");
        Scanner sc = new Scanner(System.in);
        String bookName = sc.next();
        if (addressMap.containsKey(bookName)) {                                       //we use containsKey to check if addressBook present
            addressMap.remove(bookName);                                                 // and use remove fun to remove the book
        } else {
            System.out.println("AddressBook doesn't exist, Please enter correct name.");
            deleteAddressBook();
        }
        sc.close();
    }

    /**
     * Method to print address book
     */
    public void printBook() {
        System.out.println("Address books are");
        for (String i : addressMap.keySet()) {                                     // we use keySet to get all the keys and display it
            System.out.println(i);
        }
    }

    /**
     * Method to print contact list in address book
     */
    public void printContacts() {
        for (String i : addressMap.keySet()) {
            System.out.println(i);
            System.out.println(addressMap.get(i).contacts);                     //we print the values of the key
        }
        System.out.println(" ");
    }

    /**
     * Search personin contact by city Name
     */
    public void searchByCity() {
        System.out.println("Enter the name of the City to search the persons : ");
        String cityName = sc.next();
        for (String i : addressMap.keySet()) {
            List<Contact> arr = addressMap.get(i).contacts;
            arr.stream().filter(person -> person.getCity().equals(cityName)).forEach(person -> System.out.println(person.getFirstName()));
        }
    }

    /**
     * Search Person By State
     */
    public void searchByState() {

        System.out.println("Enter the name of the State to Search persons : ");
        String stateName = sc.next();
        for (String i : addressMap.keySet()) {
            List<Contact> arr = addressMap.get(i).contacts;
            arr.stream().filter(person -> person.getState().equals(stateName)).forEach(person -> System.out.println(person.getFirstName()));
        }
    }

    /**
     * View person by city or state
     */
    public void viewPerson(HashMap<String, ArrayList<Contact>> addressMap) {
        List<Contact> contacts;
        for (String name : addressMap.keySet()) {
            System.out.println("People residing in: " + name);
            contacts = addressMap.get(name);
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }

    }

    /*
     * Method to count People living in city or state
     */
    public void countPeople(HashMap<String, ArrayList<Contact>> list) {
        System.out.println("Enter name ");
        String result = sc.next();
        long count = list.values().stream()
                .map(region -> region.stream().filter(person -> person.getState().equals(result) || person.getCity().equals(result)))
                .count();

        System.out.println("Number of people living in " + result + "are : " + count);
    }
}
