package com.distance.finder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.*;

import static java.util.Comparator.comparing;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class StoreService {
    List<Store> stores;
}
