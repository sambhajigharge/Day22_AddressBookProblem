package AddressBookByCollection;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program...!!!");
        Scanner sc = new Scanner(System.in);

        /**
         * creating object of UniqueMultipleAddressBook for adding Unique name address book
         */
        UniqueMultipleAddressBook unique = new UniqueMultipleAddressBook();

        while (true) {
            System.out.println("Enter \n    1. Add the new AddressBook \n "
                    + "2. Add new contact \n "
                    + "3. Edit the contact \n "
                    + "4. Delete the contact \n "
                    + "5. Delete the AddressBook \n "
                    + "6. Print the AddressBook \n "
                    + "7. Print the contacts \n "
                    + "8. Exit");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    unique.addAddress();
                    break;
                case 2:
                    unique.addContact();
                    break;

                case 3:
                    unique.editContact();
                    break;

                case 4:
                    unique.deleteContact();
                    break;

                case 5:
                    unique.deleteAddressBook();
                    break;
                case 6:
                    unique.printBook();
                    break;
                case 7:
                    unique.printContacts();
                case 8:
                    System.exit(8);
                    break;
                default:
                    System.out.println("Wrong Input");
            }
        }

    }
}