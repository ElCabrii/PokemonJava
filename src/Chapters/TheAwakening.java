package src.Chapters;

import src.Trainer;
import src.TextDisplayer;

public class TheAwakening {
    public static Trainer wakeUp() {
        Trainer player = Trainer.askName();
        String textToDisplay =
                "You start to wake up ...\n" +
                        "You try to remember the last night \n" +
                        "The party was amazing for your 18 years old \n" +
                        "But you drank a little bit too much... \n" +
                        "You take a quick look-around and see a Pokemon \n" +
                        "A familiar voice calls your name : \n Professor Java: " +
                        player.getName() + " ! \n" +
                        "Professor Java: I'm glad you woke up ! \n" +
                        "You tried to beat your dad in pokeshot battle last night \n" +
                        "But you lost and fell asleep \n" +
                        "He carried you in my laboratory, he wanted you to choose your first Pokemon asap!\n" +
                        "He told me that you will be a great Pokemon Trainer , and he doesnt want to pay for your food as you turned 18...\n" +
                        "You now need to choose your first Pokemon !\n" +
                        "Here are the 3 Pokemons you can choose to have : \n" +
                        "1. Bulbasaur\n" +
                        "2. Charmander\n" +
                        "3. Squirtle\n" +
                        "Which one will you go for ? Choose wisely !";
        TextDisplayer.displayParagraph(textToDisplay);
        return TheChoice.theChoice(player);
    }
}