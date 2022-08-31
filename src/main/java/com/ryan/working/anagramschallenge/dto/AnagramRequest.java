package com.ryan.working.anagramschallenge.dto;

public class AnagramRequest {
    private String wordA;
    private String wordB;

    public AnagramRequest(String wordA, String wordB) {
        this.wordA = wordA;
        this.wordB = wordB;
    }

    public String getWordA() {
        return wordA;
    }

    public String getWordB() {
        return wordB;
    }

    @Override
    public String toString() {
        return "{" + "\"wordA\" : \"" + wordA + "\", " + "\"wordB\" : \"" + wordB + "\"" + '}';
    }

}
