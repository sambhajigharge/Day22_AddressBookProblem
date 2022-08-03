package AddressBookByCollection;

import java.util.Scanner;

public class Utility {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private long zip;
    private long phoneNumber;
    private String email;
    Scanner userInput = new Scanner(System.in);

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void contactDetails() {
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


        System.out.println(getFirstName() + "\n" + getLastName() + "\n" + getAddress() + "\n" + getCity() + "\n" +
                getState() + "\n" + getZip() + "\n" + getPhoneNumber() + "\n" + getEmail());
    }

}

