package com.ryan.working.anagramschallenge.service;

import com.ryan.working.anagramschallenge.dto.AnagramRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnagramService {

    public String isAnagram(AnagramRequest anagramRequest) {
        if (anagramRequest.getWordA().length() != anagramRequest.getWordB().length()) {
            return "false";
        }

        char[] wordA = anagramRequest.getWordA().toLowerCase().toCharArray();
        char[] wordB = anagramRequest.getWordB().toLowerCase().toCharArray();

        Arrays.sort(wordA);
        Arrays.sort(wordB);

        return String.valueOf(Arrays.equals(wordA, wordB));
    }

}
