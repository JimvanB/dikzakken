package com.jim.spring.controller;

import com.jim.spring.command.DeelnemerCommand;
import com.jim.spring.service.DeelnemerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by jim on 26-11-17.
 */

public class RegistratieControllerTest {

    MockMvc mockMvc;
    RegistratieController registratieController;
    @Mock
    DeelnemerService deelnemerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        registratieController = new RegistratieController(deelnemerService);
        mockMvc = MockMvcBuilders.standaloneSetup(registratieController).build();
    }

    @Test
    public void addUser() throws Exception {
        mockMvc.perform(post("/newuser")
                .param("name", "Jim")
                .param("email", "email"));
    }

    @Test
    public void registratiePagina() throws Exception {
    }

}