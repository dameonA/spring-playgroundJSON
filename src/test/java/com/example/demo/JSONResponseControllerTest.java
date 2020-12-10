package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.print.attribute.standard.Media;
import java.awt.*;

@WebMvcTest(JSONResponseController.class)
public class JSONResponseControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testObject() throws Exception {
        this.mvc.perform(
                get("/json/simple-object")
                .accept(APPLICATION_JSON_UTF8)
                        .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Dwayne")))
                .andExpect(jsonPath("$.lastName", is("Johnson")));
    }

    @Test
    public void testArray() throws Exception {
        this.mvc.perform(
                get("/json/array")
                        .accept(APPLICATION_JSON_UTF8)
                        .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Dwayne")))
                .andExpect(jsonPath("$[0].lastName", is("Johnson")));
    }

        )

    }
}
