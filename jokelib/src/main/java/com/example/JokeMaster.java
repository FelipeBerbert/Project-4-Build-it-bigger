package com.example;

import java.util.ArrayList;
import java.util.Random;

public class JokeMaster {

    ArrayList<String> jokes;


    public JokeMaster(){
        String joke1 = "Why are pizza makers always poor? Because they knead dough to make a living.";
        String joke2 = "I hate those Russian dolls... They're so full of themselves.";
        jokes = new ArrayList<>();
        jokes.add(joke1);
        jokes.add(joke2);
    }

    public String getRandomJoke(){
        if (jokes != null)
        return jokes.get(new Random().nextInt(jokes.size()));
        else
            return "Could not fetch joke";
    }
}
