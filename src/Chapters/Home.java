package src.Chapters;
import src.Chapters.TheChoice;

import java.util.Scanner;

public class Home {
    public static void home{
        String[] textToDisplay =
                {"You go back to your house. \n" +
                        "Your mom is waiting for you. \n" +
                        "Mom: Hi honey, how was your day ? \n" +
                        "Trainer.getName: It was great mom, I chose my first Pokemon ! \n" +
                        "Now I am going to beging my travel! \n" +
                        "Say bye to papa for me! \n"
                        "Mom: I will honey, take care of yourself and your Pokemon! \n" +
                        "Trainer.getName: I will mom, I promise! \n" +
                        "You start to move towards the street. \n" +
                        "You see your rival waiting for you. \n" +
                        "JavaScrypt: Hey, I was waiting for you! \n" +
                        "Trainer.getName: Hey, what's up? \n" +
                        "JavaScrypt: I am going to be the best Pokemon trainer! \n" +
                        "I will beat you and become the champion! \n" +
                        "Trainer.getName: We will see about that! \n" +
                        "JavaScrypt: Let's battle! \n",
                        "Trainer.getName: You see, i'm already better! \n" +


                }
                TextDisplayer.displayParagraph(textToDisplay[0]);
                fight(JavaScrypt);
    }
}