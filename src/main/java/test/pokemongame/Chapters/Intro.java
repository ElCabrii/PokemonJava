package test.pokemongame.Chapters;

import test.pokemongame.TextDisplayer;
import test.pokemongame.Trainer;

public class Intro {
    public static Trainer start() {
        String textToDisplay = TextDisplayer.readStoryFile("data/story1/Intro");

        TextDisplayer.printWithDelay(textToDisplay);

       return TheAwakening.wakeUp();
    }
}