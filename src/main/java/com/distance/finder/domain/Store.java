package com.distance.finder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@NoArgsConstructor
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
}
