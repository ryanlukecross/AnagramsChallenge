package com.ryan.working.anagramschallenge.dto;

public class AnagramResponse {
    private String result;

    public AnagramResponse(String isAnagram) {
        this.result = isAnagram;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
