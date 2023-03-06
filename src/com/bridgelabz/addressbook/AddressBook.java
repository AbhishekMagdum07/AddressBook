package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
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
    public static void main(String[] args) {
        create();
    }
}
