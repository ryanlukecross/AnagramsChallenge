package com.ryan.working.anagramschallenge.service;

import com.ryan.working.anagramschallenge.dto.AnagramRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AnagramServiceTests {

    @Autowired
    AnagramService anagramService;


    @Test
    public void anagramSuccess() {
        // given
        AnagramRequest success = new AnagramRequest("bored", "robed");

        // when
        String isAnagram = anagramService.isAnagram(success);

        // then
        assertEquals("true", isAnagram);
    }

    @Test
    public void anagramFailLength() {
        // given
        AnagramRequest failLength = new AnagramRequest("boredd", "robed");

        // when
        String isAnagram = anagramService.isAnagram(failLength);

        // then
        assertEquals("false", isAnagram);
    }

    @Test
    public void anagramFailLetter() {
        // given
        AnagramRequest failLetter = new AnagramRequest("bored", "robeb");

        // when
        String isAnagram = anagramService.isAnagram(failLetter);

        // then
        assertEquals("false", isAnagram);
    }

}
