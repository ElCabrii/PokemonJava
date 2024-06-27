package com.pokemongame.Chapters;

import com.pokemongame.TextDisplayer;
import com.pokemongame.Trainer;

public class Intro {
    public static Trainer start() {
        String textToDisplay = TextDisplayer.readStoryFile("data/story1/Intro");

        TextDisplayer.printWithDelay(textToDisplay);

       return TheAwakening.wakeUp();
    }
}