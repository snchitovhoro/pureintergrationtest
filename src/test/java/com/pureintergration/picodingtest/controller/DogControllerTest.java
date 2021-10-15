package com.pureintergration.picodingtest.controller;

import com.pureintergration.picodingtest.model.Dog;
import com.pureintergration.picodingtest.service.IDogService;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Array;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDogService dogService;

    @Test
    public void dogsShouldreturnListofDogs() throws Exception {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        when(dogService.getall()).thenReturn(Arrays.asList(new Dog[2](dog1, dog2));

        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk());
                //.andExpect(content().contentType("application/json"))
                //.andExpect(jsonPath("$", hasSize(2)));

    }
}
