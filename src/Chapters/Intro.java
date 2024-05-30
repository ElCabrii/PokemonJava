package src.Chapters;

import src.TextDisplayer;

public class Intro {
    public static void introduction(String[] args) {
        String textToDisplay =
                "Welcome in a new world !!!\n" +
                        "A world full of mysterious creature called : Pokemon !\n" +
                        "You reached the age required for start your own adventure. \n" +
                        "In this world, you will meet a lot of people, some of them will be your friends, some of them will be your ennemies.\n" +
                        "Your goal is to become the best Pokemon Trainer in the world. \n" +
                        "But before that, you need to choose your first Pokemon \n" +
                        "Let's go !";


        TextDisplayer.displayTextCharacterByCharacter(textToDisplay);

       TheAwakening.wakeUp(args);


    }
}