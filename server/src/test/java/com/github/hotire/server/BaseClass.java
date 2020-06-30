package com.github.hotire.server;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class BaseClass {

    @Autowired
    private PersonController personController;

    @MockBean
    private PersonService personService;

    @Before
    public void setup() {
        // given
        RestAssuredMockMvc.standaloneSetup(personController);

        // when
        when(personService.findPersonById(1L)).thenReturn(Optional.of(new Person(1L, "foo", "bee")));
    }

}
