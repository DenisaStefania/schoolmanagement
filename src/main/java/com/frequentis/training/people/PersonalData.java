package com.frequentis.training.people;

public class PersonalData {
    private String name;
    private Address address;
    private ContactDetails contactDetails;

    public PersonalData(String name, Address address, ContactDetails contactDetails) {
        this.name = name;
        this.address = address;
        this.contactDetails = contactDetails;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", address=" + address +
                ", contactDetails=" + contactDetails +
                '}';
    }
}
