package com.addressbook;

public class AddressBook {
    private String firstName, lastName, address, city, state, zip, phoneNumber, email;

    public AddressBook(String firstName, String lastName, String address, String city, String state, String zip, String ph_no, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = ph_no;
        this.email = email;
    }

    public String toString() {
        return "\nFirst name: " + firstName + "\nLast name: " + lastName
                + "\nAddress: " + address + "\nCity: " + city
                + "\nState: " + state + "\nZip: " + zip
                + "\nPhone number: " + phoneNumber + "\nEmail address: " + email;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String ph_no) {
        this.phoneNumber = ph_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

