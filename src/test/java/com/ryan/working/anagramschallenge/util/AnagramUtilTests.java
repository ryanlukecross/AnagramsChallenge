package com.ryan.working.anagramschallenge.util;

import com.ryan.working.anagramschallenge.dto.AnagramRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AnagramUtilTests {

    @Autowired
    AnagramUtil anagramUtil;


    @Test
    public void anagramSuccess() {
        // given
        AnagramRequest success = new AnagramRequest("bored", "robed");

        // when
        String isAnagram = anagramUtil.isAnagram(success);

        // then
        assertEquals("true", isAnagram);
    }

    @Test
    public void anagramFailLength() {
        // given
        AnagramRequest failLength = new AnagramRequest("boredd", "robed");

        // when
        String isAnagram = anagramUtil.isAnagram(failLength);

        // then
        assertEquals("false", isAnagram);
    }

    @Test
    public void anagramFailLetter() {
        // given
        AnagramRequest failLetter = new AnagramRequest("bored", "robeb");

        // when
        String isAnagram = anagramUtil.isAnagram(failLetter);

        // then
        assertEquals("false", isAnagram);
    }

}
