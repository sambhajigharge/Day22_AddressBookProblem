package AddressBookByCollection;

public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to Address book Program");
        Utility utility = new Utility();
        utility.contactDetails();

        Utility utility1 = new Utility();
        System.out.println("Add Second contact details \n");
        utility1.contactDetails();

        Utility utility2 = new Utility();
        System.out.println("Add Third contact details \n");
        utility2.contactDetails();
    }
}

