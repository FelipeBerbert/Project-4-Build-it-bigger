package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JokeMaster {

    ArrayList<String> jokes;


    public JokeMaster(){
        String jokeList = "I hate those Russian dolls... They're so full of themselves.|Why are pizza makers always poor? Because they knead dough to make a living.|Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.|I find it ironic that the colors red, white, and blue stand for freedom until they are flashing behind you.|Isn't it great to live in the 21st century? Where deleting history has become more important than making it.|Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?|That awkward moment when you leave a store without buying anything and all you can think is \"act natural, you're innocent\".|Life is all about perspective. The sinking of the Titanic was a miracle to the lobsters in the ship's kitchen.";
        jokes = new ArrayList<>();
        jokes.addAll(Arrays.asList(jokeList.split("\\|")));
    }

    public String getRandomJoke(){
        if (jokes != null)
        return jokes.get(new Random().nextInt(jokes.size()));
        else
            return "Could not fetch joke";
    }
}
