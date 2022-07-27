package com.example.controller;

import com.github.javafaker.Faker;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.ArrayList;
import java.util.List;

@Controller("v1/test")
public class BenchmarkController {

    Faker faker = new Faker();

    @Get("/lebowski")
    public List<String> getLebowskiQuotes() {
        return List.of(faker.lebowski().quote(), faker.lebowski().quote(), faker.lebowski().quote(), faker.lebowski().quote(), faker.lebowski().quote());
    }

    @Get("/witcher")
    public List<String> getWitcherCharacters() {
        var characters = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            characters.add(faker.witcher().character());
        }
        return characters;
    }
}
