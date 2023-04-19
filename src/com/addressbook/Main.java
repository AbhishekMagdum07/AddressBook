package com.addressbook;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main{
    static String name;
    static Main output = new Main(name);
    Scanner sc = new Scanner(System.in);
    static int option;
    static AddressBook contact;
    static ArrayList <AddressBook> contacts = new ArrayList<>();
    HashMap<String, ArrayList<AddressBook>> multipleAdd;
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

    public Main(String name) {
        this.name = name;
        this.multipleAdd = new HashMap<String, ArrayList<AddressBook>>();
    }

    public void addContacts () {
        System.out.println("name of addressbook");
        String name = sc.next();
//        if (contacts.isEmpty()) {
        contacts.add(contact);
        this.multipleAdd.put(name, contacts);
//        } else {
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
         List<AddressBook> searchByCity = contacts.stream().filter(x -> x.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
         searchByCity.forEach(x -> System.out.println(x));
    }
    public void searchByState(String state) { // search contact on basis of state.
        List<AddressBook> searchByState = contacts.stream().filter(x -> x.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
        searchByState.forEach(x -> System.out.println(x));
    }
    public void contactNo(String city) {   // get contact on basis of city name
        List<AddressBook>  contactDetails = contacts.stream().filter(x -> x.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        System.out.println(contact.getPhoneNumber());
    }
    public void sortByName() { // sorting contacts on basis of name.
       List<AddressBook> sorting = contacts.stream().sorted(Comparator.comparing(AddressBook::getFirstName)).collect(Collectors.toList());
        System.out.println(sorting);
    }
    public void sortByState(){ // sorting contacts on basis of state name.
        List<AddressBook> sorting = contacts.stream().sorted(Comparator.comparing(AddressBook::getState)).collect(Collectors.toList());
        System.out.println(sorting);
    }

    public void writeFile() { // Uc13- Ability to write contacts in file.
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Employee.txt"));
            writer.write(String.valueOf(contacts));
            writer.close();
            File file = new File("E:\\Employee.txt");
            if (file.exists()) {
                System.out.println("File Created Successfully");
            } else {
                System.out.println("File is not created.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readFile(){ // Reading contacts using File handling.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\Employee.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCsvFile() { // Uc14- Ability to write contacts in CSV file.
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\AddressBook.csv"));
            writer.write(String.valueOf(contacts));
            writer.close();
            File file = new File("E:\\AddressBook.csv");
            if (file.exists()) {
                System.out.println("File Created Successfully");
            } else {
                System.out.println("File is not created.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readCsvFile(){ // Reading contacts using CSV File handling.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\AddressBook.csv"));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choices() {
        System.out.println("Select from the following = \n1. Add contact 2. Edit contact 3. Delete contact 4. Display contact 5.search" +
                                " 6.Contact by city  7.sort by name 8.sort by state 9.Write File 10.Read file 11.Write CSV File 12.Read CSV File 13.Exit ");
        option = sc.nextInt();
        switch(option) {
            case 1:
                output.createContacts();
                output.addContacts();
                output.choices();break;
            case 2:
                System.out.println("Enter the first name to search contact");
                sreachName = sc.next();
                output.editContacts();
                output.choices();break;
            case 3:
                System.out.println("Enter the first name  delete contact ");
                sreachName = sc.next();
                output.deleteContact();
                output.choices();break;
            case 4:

                System.out.println("Enter addressbook name");
                String input = sc.next();
                System.out.println(multipleAdd.get(input));
                choices();
                break;
            case 5:
                System.out.println("1. Search by city 2. Search by state");
                int option2 = sc.nextInt();
                if(option2 == 1) {
                    System.out.println("Enter the city name to search");
                    String citySearch = sc.next();
                    output.searchByCity(citySearch);
                }
                else if(option2 == 2) {
                    System.out.println("Enter the state name to search");
                    String stateSearch = sc.next();
                    output.searchByState(stateSearch);
                }
                choices();
                break;
            case  6:
                System.out.println("Enter the city name");
                contactNo(sc.next());
                choices();
            case 7:
               output.sortByName();
                choices();
                break;
            case 8:
                output.sortByState();
                choices();
                break;
            case 9:
                output.writeFile();
                choices();
            case 10:
               output.readFile();
               choices();
            case 11:
                output.writeCsvFile();
                choices();
            case 12:
                output.readCsvFile();
                choices();

            case 13:
                System.exit(0);break;
            default:
                System.out.println("Invalid option");
        }
    }

    public static void main(String[] args) {
        output.choices();
    }
}