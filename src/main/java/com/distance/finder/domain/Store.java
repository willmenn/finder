package com.distance.finder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private String addressName;
    private String city;
    private String postalCode;
    private String street;
    private String street2;
    private String street3;
    private Double latitude;
    private Double longitude;
    private String complexNumber;
    private String uuid;
}
