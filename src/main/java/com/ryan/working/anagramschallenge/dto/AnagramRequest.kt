package com.ryan.working.anagramschallenge.dto

data class AnagramRequest(val wordA: java.lang.String, val wordB: java.lang.String) {

    override fun toString(): String = "{\"wordA\" : \"$wordA\", \"$wordB\" : \"robed\"}";

}