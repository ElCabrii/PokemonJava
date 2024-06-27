package com.pokemongame.Chapters;

import com.pokemongame.Trainer;
import com.pokemongame.TextDisplayer;

public class TheAwakening {
    public static Trainer wakeUp() {
        Trainer player = Trainer.askName();
        String[] textToDisplay = {
                TextDisplayer.readStoryFile("data/story1/TheAwakening1"),
                TextDisplayer.readStoryFile("data/story1/TheAwakening2")
        };
        textToDisplay[1]=textToDisplay[1].replace("player.getName()", player.getName());
        TextDisplayer.printWithDelay(textToDisplay[0]);
        TextDisplayer.printWithDelay(textToDisplay[1]);
        return TheChoice.theChoice(player);
    }
}