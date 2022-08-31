package com.ryan.working.anagramschallenge.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class AnagramsChallengeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRequestTest() throws Exception {
        // given
        MockHttpServletRequestBuilder requestBuilder = get("/isAnagram");

        // when, then
        this.mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(content().string(containsString("please use a rest client to make a POST request to this endpoint containing the following object: {\"wordA\" : \"bored\", \"wordB\" : \"robed\"}")));

    }

    @Test
    public void postRequestSuccessTest() throws Exception {
        // given
        String contentString = "{\"wordA\" : \"bored\", \"wordB\" : \"robed\"}";
        MockHttpServletRequestBuilder requestBuilder = post("/isAnagram").contentType(MediaType.APPLICATION_JSON).content(contentString).accept(MediaType.APPLICATION_JSON);

        // when, then
        this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(content().json("{\"result\":\"true\"}"));

    }

    @Test
    public void postRequestFailTest() throws Exception {
        // given
        String contentString = "{\"wordA\" : \"bored\", \"wordB\" : \"robedd\"}";
        MockHttpServletRequestBuilder requestBuilder = post("/isAnagram").contentType(MediaType.APPLICATION_JSON).content(contentString).accept(MediaType.APPLICATION_JSON);

        // when, then
        this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(content().json("{\"result\":\"false\"}"));

    }

}
