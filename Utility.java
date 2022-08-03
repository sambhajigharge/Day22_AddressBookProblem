package AddressBookByCollection;

import java.util.ArrayList;
import java.util.Scanner;

public class Utility {
    static ArrayList<Utility> contactList = new ArrayList<>();
    Scanner userInput = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private long zip;
    private long phoneNumber;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void contactDetails(Utility contactItems, ArrayList<Utility> contactList) {
        contactItems = new Utility();

        System.out.println("Enter your First Name :");
        setFirstName(userInput.nextLine());

        System.out.println("Enter your Last Name :");
        setLastName(userInput.nextLine());

        System.out.println("Enter your Address :");
        setAddress(userInput.nextLine());

        System.out.println("Enter your City Name :");
        setCity(userInput.nextLine());

        System.out.println("Enter your State Name :");
        setState(userInput.nextLine());

        System.out.println("Enter your Zip code :");
        setZip(userInput.nextLong());

        System.out.println("Enter your Phone Number :");
        setPhoneNumber(userInput.nextLong());

        System.out.println("Enter your Email ID :");
        setEmail(userInput.next());

        contactList.add(contactItems);
    }

    public void editContact() {

        System.out.println("Enter the first name of contact you wish to edit");
        String edit = userInput.nextLine();
        System.out.println("Press 1 - To edit first name");
        System.out.println("Press 2 - To edit last name");
        System.out.println("Press 3 - To edit address");
        System.out.println("Press 4 - To edit city");
        System.out.println("Press 5 - To edit state");
        System.out.println("Press 6 - To edit zip code");
        System.out.println("Press 7 - To edit phone number");
        System.out.println("Press 8 - To edit email");

        int option = userInput.nextInt();
        switch (option) {
            case 1:
                for (Utility contactItems : contactList) {
                    if (contactItems.firstName.equals(edit)) {
                        System.out.println("Enter new first name");
                        contactItems.firstName = userInput.next();
                    }
                }
            case 2:
                for (Utility contactItems : contactList) {
                    if (contactItems.firstName.equals(edit)) {
                        System.out.println("Enter new first name");
                        contactItems.lastName = userInput.next();
                    }
                }
            case 3:
                for (Utility contactItems : contactList) {
                    if (contactItems.firstName.equals(edit)) {
                        System.out.println("Enter new first name");
                        contactItems.address = userInput.next();
                    }
                }
            case 4:
                for (Utility contactItems : contactList) {
                    if (contactItems.firstName.equals(edit)) {
                        System.out.println("Enter new first name");
                        contactItems.city = userInput.next();
                    }
                }
            case 5:
                for (Utility contactItems : contactList) {
                    if (contactItems.firstName.equals(edit)) {
                        System.out.println("Enter new first name");
                        contactItems.state = userInput.next();
                    }
                }
            case 6:
                for (Utility contactItems : contactList) {
                    if (contactItems.firstName.equals(edit)) {
                        System.out.println("Enter new first name");
                        contactItems.zip = userInput.nextInt();
                    }
                }
            case 7:
                for (Utility contactItems : contactList) {
                    if (contactItems.firstName.equals(edit)) {
                        System.out.println("Enter new first name");
                        contactItems.phoneNumber = userInput.nextInt();
                    }
                }
            case 8:
                for (Utility contactItems : contactList) {
                    if (contactItems.firstName.equals(edit)) {
                        System.out.println("Enter new first name");
                        contactItems.email = userInput.next();
                    }
                }
            default:
                System.out.println("Enter Proper Choice !");
        }
    }

    public void addContactList() {
        while (true) {
            System.out.println("Enter your option :");
            System.out.println("0 for Add new Contact");
            System.out.println("1 for Edit Contact");
            System.out.println("3 Display all Contact");
            System.out.println("4 Delete contact");
            System.out.println("6 for Exit");

            int option = userInput.nextInt();
            switch (option) {
                case 0 -> contactDetails(null, contactList);
                case 1 -> editContact();
                case 2 -> display(contactList);
                case 3 -> deleteContact(contactList);
            }
            if (option == 6) {
                break;
            }
        }
    }

    
    private void deleteContact(ArrayList<Utility> contactList) {
        System.out.println("Enter the first name of the contact you wish to delete");
        String delete = userInput.next();
        contactList.removeIf(contact -> contact.firstName.equals(delete));
    }

    public void display(ArrayList<Utility> contactList)//Display Address book
    {
        for (Utility contact : contactList) {
            System.out.println(contact);
        }
    }

    public String toString() {
        return "ContactItems [firstName=" + firstName
                + ", lastName=" + lastName + ", address=" + address
                + ", city=" + city + ", state=" + state + ", zip=" + zip
                + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
    }
}