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
    private Double longitude;
    private Double latitude;
    private String complexNumber;
    private int distance;

    Store copy(int distance) {
        return new Store(this.addressName, this.city, this.postalCode,
                this.street, this.street2, this.street3, this.longitude, this.latitude, this.complexNumber, distance);
    }

    private Store(String addressName, String city, String postalCode, String street, String street2, String street3,
                  Double longitude, Double latitude, String complexNumber, int distance) {
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

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getComplexNumber() {
        return complexNumber;
    }

    int getDistance() {
        return distance;
    }
}
