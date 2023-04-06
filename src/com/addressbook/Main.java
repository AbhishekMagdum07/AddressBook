package com.addressbook;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main{
    static Main addressBook = new Main();
    Scanner sc = new Scanner(System.in);
    static int option;
    static AddressBook contact;
    static ArrayList <AddressBook> contacts = new ArrayList<AddressBook>();
    static List<AddressBook> duplicate;
    static List<AddressBook> searchByCity;
    static List<AddressBook> searchByState;

    String sreachName;
    public void createContacts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details =");
        System.out.println("Enter first name =");
        String firstName = sc.next();
        System.out.println("Enter last name =");
        String lastName = sc.next();
        System.out.println("Enter address =");
        String address  = sc.next();
        System.out.println("Enter city =");
        String city  = sc.next();
        System.out.println("Enter state =");
        String state = sc.next();
        System.out.println("Enter Zip code =");
        String zip = sc.next();
        System.out.println("Enter phone number =");
        String ph_no = sc.next();
        System.out.println("Enter the email address");
        String email = sc.next();
        System.out.println("Contact created");
        contact = new AddressBook(firstName,lastName,address,city,state,zip,ph_no,email);
    }
    public void addContacts () {
        if (contacts.isEmpty()) {
            contacts.add(contact);
        } else {                                // using stream for find duplicate contacts.
            duplicate = contacts.stream().filter(a -> a.getFirstName().equals(a.getFirstName())).collect(Collectors.toList());
            if (contacts.equals(duplicate)) {
                System.out.println("This contact is already present in addressbook");
            } else {
                contacts.add(contact);
            }
        }
    }


    public void editContacts() {
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getFirstName().equalsIgnoreCase(sreachName)) {
                System.out.println("Choose inbetween\n1.First name 2.Last name 3.Address" +
                        " 4.City 5.State 6.Zip 7.Phone number 8.Email address");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Enter the first name =");
                        contacts.get(i).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter the last name =");
                        contacts.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter the address =");
                        contacts.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter the city  =");
                        contacts.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter the state =");
                        contacts.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter the zip code =");
                        contacts.get(i).setZip(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter the phone number =");
                        contacts.get(i).setPhoneNumber(sc.next());
                        break;
                    case 8:
                        System.out.println("Enter the email address =");
                        contacts.get(i).setEmail(sc.next());
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            }
        }

    }
    public void deleteContact() {
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getFirstName().equalsIgnoreCase(sreachName)) {
                contacts.remove(i);
                System.out.println("Contats Deleted successfully"+contacts.size());
            }
        }
    }
    public void searchByCity(String city) {   // search contact on basis of city name.
        searchByCity = contacts.stream().filter(x -> x.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        searchByCity.forEach(x -> System.out.println(x));
    }
    public void searchByState(String state) { // search contact on basis of state.
        searchByState = contacts.stream().filter(x -> x.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
        searchByState.forEach(x -> System.out.println(x));
    }
    public void choices() {
        System.out.println("Select from the following = \n1. Add contact 2. Edit contact 3. Delete contact 4. Display contact 5.search  6.Exit");
        option = sc.nextInt();
        switch(option) {
            case 1:
                addressBook.createContacts();
                addressBook.addContacts();
                addressBook.choices();break;
            case 2:
                System.out.println("Enter the first name to search and edit contact with first name");
                sreachName = sc.next();
                addressBook.editContacts();
                addressBook.choices();break;
            case 3:
                System.out.println("Enter the first name to search and edit contact with first name");
                sreachName = sc.next();
                addressBook.deleteContact();
                addressBook.choices();break;
            case 4:
                System.out.println("Enter the contact's first name to display");
                sreachName = sc.next();
                for(int i = 0; i < contacts.size(); i++) {
                    if(contacts.get(i).getFirstName().equalsIgnoreCase(sreachName)) {
                        System.out.println(contacts.get(i));
                        addressBook.choices();
                    }
                }break;
            case 5:
                System.out.println("1. Search by city 2. Search by state");
                int option2 = sc.nextInt();
                if(option2 == 1) {
                    System.out.println("Enter the city name to search");
                    String citySearch = sc.next();
                    addressBook.searchByCity(citySearch);
                }
                else if(option2 == 2) {
                    System.out.println("Enter the state name to search");
                    String stateSearch = sc.next();
                    addressBook.searchByState(stateSearch);
                }
                choices();
                break;
            case 6:
                System.exit(0);break;
            default:
                System.out.println("Invalid option");
        }
    }

    public static void main(String[] args) {
        addressBook.choices();
    }
}