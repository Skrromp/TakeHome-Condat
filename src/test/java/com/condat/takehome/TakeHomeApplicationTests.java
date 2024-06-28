package com.condat.takehome;

import com.condat.takehome.controller.CalculatorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(classes = {CalculatorController.class})
class TakeHomeApplicationTests {

    @Autowired
    MockMvc mvc;

    // /add ENDPOINT TESTS
    @Test
    public void addTestShouldReturn200() throws Exception {
        mvc.perform(get("/add")
                        .param("num1", "10")
                        .param("num2", "5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value(15.0));
    }

    @Test
    public void addCharacterTestShouldReturn400() throws Exception {
        mvc.perform(get("/add")
                        .param("num1", "a")
                        .param("num2", "5"))
                .andExpect(status().isBadRequest());
    }

    // /sub ENDPOINT TESTS
    @Test
    public void subTestShouldReturn200() throws Exception {
        mvc.perform(get("/sub")
                        .param("num1", "10")
                        .param("num2", "5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value(5.0));
    }

    @Test
    public void subCharacterTestShouldReturn400() throws Exception {
        mvc.perform(get("/sub")
                        .param("num1", "a")
                        .param("num2", "5"))
                .andExpect(status().isBadRequest());
    }

    // /mul ENDPOINT TESTS
    @Test
    public void mulTestShouldReturn200() throws Exception {
        mvc.perform(get("/mul")
                        .param("num1", "10")
                        .param("num2", "5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value(50.0));
    }

    @Test
    public void mulCharacterTestShouldReturn400() throws Exception {
        mvc.perform(get("/mul")
                        .param("num1", "a")
                        .param("num2", "5"))
                .andExpect(status().isBadRequest());
    }

    // /div ENDPOINT TESTS
    @Test
    public void divTestShouldReturn200() throws Exception {
        mvc.perform(get("/div")
                        .param("num1", "10")
                        .param("num2", "5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value(2.0));
    }

    @Test
    public void divCharacterTestShouldReturn400() throws Exception {
        mvc.perform(get("/div")
                        .param("num1", "a")
                        .param("num2", "5"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void divByZeroTestShouldReturn400() throws Exception {
        mvc.perform(get("/div")
                        .param("num1", "5")
                        .param("num2", "0"))
                .andExpect(status().isBadRequest());
    }
}
