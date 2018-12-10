package com.distance.finder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Store {
    private String addressName;
    private String city;
    private String postalCode;
    private String street;
    private String street2;
    private String street3;
    private String longitude;
    private String latitude;
    private String complexNumber;
    private int distance;

    Store copy(int distance) {
        return new Store(this.addressName, this.city, this.postalCode,
                this.street, this.street2, this.street3, this.longitude, this.latitude, this.complexNumber, distance);
    }

    private Store(String addressName, String city, String postalCode, String street, String street2, String street3,
                  String longitude, String latitude, String complexNumber, int distance) {
        this.addressName = addressName;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.street2 = street2;
        this.street3 = street3;
        this.longitude = longitude;
        this.latitude = latitude;
        this.complexNumber = complexNumber;
        this.distance = distance;
    }

    public Store() {
    }

    public String getAddressName() {
        return addressName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getStreet2() {
        return street2;
    }

    public String getStreet3() {
        return street3;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getComplexNumber() {
        return complexNumber;
    }

    int getDistance() {
        return distance;
    }

//    public void setAddressName(String addressName) {
//        this.addressName = addressName;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public void setStreet2(String street2) {
//        this.street2 = street2;
//    }
//
//    public void setStreet3(String street3) {
//        this.street3 = street3;
//    }
//
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }
//
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
//
//    public void setComplexNumber(String complexNumber) {
//        this.complexNumber = complexNumber;
//    }

    @Override
    public String toString() {
        return "Store{" +
                "city='" + city + '\'' +
                '}';
    }
}
