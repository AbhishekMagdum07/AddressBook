package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static ArrayList<String> contats = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String firstName,lastName,address,city,state,email,zip,phoneNo;

    AddressBook(String firstName, String lastName, String address, String city, String state, String zip, String phoneNo, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    public String toString(){
        return "First Name = "+firstName+"\nLast Name = "+lastName+"\nAddress = "+address+"\nCity = "+city+"\nstate = "+state+"\nzip = "+zip+"\nphoneNo = "+phoneNo+"\nemail = "+email;
    }

    public static void create() {
        System.out.println("Persons Details ::");
        System.out.println("Enter FirstName = ");
        String firstName = sc.next();
        System.out.println("Enter LastName = ");
        String lastName = sc.next();
        System.out.println("Enter Address = ");
        String address = sc.next();
        System.out.println("Enter City = ");
        String city = sc.next();
        System.out.println("Enter State = ");
        String state = sc.next();
        System.out.println("Enter Zip = ");
        String zip = sc.next();
        System.out.println("Enter PhoneNumber = ");
        String phoneNo = sc.next();
        System.out.println("Enter Email = ");
        String email = sc.next();

        AddressBook employee = new AddressBook(firstName, lastName, address, city, state, zip, phoneNo, email);
        System.out.println(employee.toString());
    }

    public static void add(){
        contats.add(firstName);
        contats.add(lastName);
        contats.add(address);
        contats.add(city);
        contats.add(state);
        contats.add(zip);
        contats.add(phoneNo);
        contats.add(email);

        System.out.println("Contats added Successfully");
        for(String run : contats) {
           System.out.println(run);
         }
    }

    public static void edit(){
        System.out.println("Choose Element to edit and press number accordingly");
        System.out.println("0.firstName ,1.lastName, 2.address, 3.city, 4.state, 5.zip, 6.phoneNo, 7.email");
        int choice = sc.nextInt();

        switch (choice){
            case 0 : contats.set(0,sc.next());break;
            case 1 : contats.set(1,sc.next());break;
            case 2 : contats.set(2,sc.next());break;
            case 3 : contats.set(3,sc.next());break;
            case 4 : contats.set(4,sc.next());break;
            case 5 : contats.set(5,sc.next());break;
            case 6 : contats.set(6,sc.next());break;
            case 7 : contats.set(7,sc.next());break;
            default:
                System.out.println("You made wrong choice");
        }

        System.out.println("Contats added Successfully");
        for(String run : contats) {
            System.out.println(run);
        }

    }

    public static void delete(){
        System.out.println("Enter name to delete contact =" );
        String name = sc.next();
        if(name.equals(contats.get(0))){
            for(int i=0 ;i>contats.size() ;i++){
                contats.remove(i);
            }
        }else {
            System.out.println("Enter valid name = ");
        }
        System.out.println("Contact deleted Successfully.");
    }
    public static void main(String[] args) {
        create();
        add();
        edit();
        delete();

    }
}
