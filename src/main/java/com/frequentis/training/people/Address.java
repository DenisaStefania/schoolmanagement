package com.frequentis.training.people;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private int number;

    public Address(String country, String region, String city, String street, int number) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
