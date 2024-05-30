package src.Destination;

import src.TextDisplayer;

public class Home {
    public static void home(){
        String textToDisplay =
                "You are now at home\n" +
                "You can go to the laboratory or the park\n" +
                "Enter the name of the destination you want to go to : ";


        TextDisplayer.displayParagraph(textToDisplay);
    }
}
