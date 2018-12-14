package com.distance.finder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.distance.finder.domain.StoreAndDistanceStub.AMSTERDAM;
import static com.distance.finder.domain.StoreAndDistanceStub.BRUSSELS;
import static com.distance.finder.domain.StoreAndDistanceStub.LUXEMBOURG;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FinderApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldBeAbleToGetTheNearsStoresFromAmsterdam() throws Exception {
        this.mockMvc.perform(get("/stores/nearby")
                .param("latitude", AMSTERDAM.getLatitude().toString())
                .param("longitude", AMSTERDAM.getLongitude().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].uuid", is("R74KYx4XucoAAAFIqY8YwKxK")))
                .andExpect(jsonPath("[1].uuid", is("dhkKYx4XS0UAAAFcnMNlwJ7N")))
                .andExpect(jsonPath("[2].uuid", is("qisKYx4X6wwAAAFY.DNSOmWN")))
                .andExpect(jsonPath("[3].uuid", is("5KsKYx4XUj8AAAFJ7S5Gp2Rc")))
                .andExpect(jsonPath("[4].uuid", is("bBkKYx4XaBwAAAFNDfk7fpNP")));
    }

    @Test
    public void shouldBeAbleToGetTheNearsStoresFromBrussels() throws Exception {
        this.mockMvc.perform(get("/stores/nearby")
                .param("latitude", BRUSSELS.getLatitude().toString())
                .param("longitude", BRUSSELS.getLongitude().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].uuid", is("SCgKYx4XPxwAAAFbXlxmxNDP")))
                .andExpect(jsonPath("[1].uuid", is("sMkKYx4XsAUAAAFRato6N_Bz")))
                .andExpect(jsonPath("[2].uuid", is("iqYKYx4XlBMAAAFInSsYwKWg")))
                .andExpect(jsonPath("[3].uuid", is("emQKYx4XIEIAAAFIB8IYwKxJ")))
                .andExpect(jsonPath("[4].uuid", is("hPoKYx4XM.4AAAFIEd4YwKxJ")));
    }

    @Test
    public void shouldBeAbleToGetTheNearsStoresFromLuxembourg() throws Exception {
        this.mockMvc.perform(get("/stores/nearby")
                .param("latitude", LUXEMBOURG.getLatitude().toString())
                .param("longitude", LUXEMBOURG.getLongitude().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].uuid", is("G7kKYx4XcAIAAAFI8lsYwKxK")))
                .andExpect(jsonPath("[1].uuid", is("c3MKYx4XrCoAAAFI7tMYwKxK")))
                .andExpect(jsonPath("[2].uuid", is("fXAKYx4XKmYAAAFJVw0YZ4CR")))
                .andExpect(jsonPath("[3].uuid", is("25gKYx4XlhEAAAFIIf8YwKxJ")))
                .andExpect(jsonPath("[4].uuid", is("wr8KYx4XTo8AAAFdyM84dS7_")));
    }

}
