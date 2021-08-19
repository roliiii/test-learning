package com.fluffy.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluffy.test.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PeopleController.class)
class PeopleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeopleService service;

    @Test
    public void test() throws Exception {
        PeopleDto dto = new PeopleDto();
        dto.setEmail("fluffy@fluffy.fluf");
        dto.setName("fluffy");

        MockHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.post("/people")
                    .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dto));
        mockMvc.perform(postRequest).andExpect(MockMvcResultMatchers.status().is(200));

        Mockito.verify(service, Mockito.times(1)).addPeople(ArgumentMatchers.any(PeopleDto.class));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}