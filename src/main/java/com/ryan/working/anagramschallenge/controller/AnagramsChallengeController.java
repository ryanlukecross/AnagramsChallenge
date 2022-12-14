package com.ryan.working.anagramschallenge.controller;

import com.ryan.working.anagramschallenge.dto.AnagramRequest;
import com.ryan.working.anagramschallenge.dto.AnagramResponse;
import com.ryan.working.anagramschallenge.service.AnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnagramsChallengeController {

    @Autowired
    AnagramService anagramService;

    @GetMapping("/isAnagram")
    @ResponseBody
    public String isAnagram() {
        return "please use a rest client to make a POST request to this endpoint containing the following object: " + new AnagramRequest("bored", "robed");
    }

    @PostMapping("/isAnagram")
    @ResponseBody
    public AnagramResponse isAnagram(@RequestBody AnagramRequest anagramRequest) {
        return new AnagramResponse(anagramService.isAnagram(anagramRequest));
    }

}
