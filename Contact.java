package AddressBookByCollection;

public class Contact {
    // variable declaration
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    long phoneNumber;
    String email;

    //returning person details given by user
    public String toString() {
        return "ContactItems [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
                + city + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email=" + email
                + "]";
    }
}

