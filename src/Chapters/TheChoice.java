package src.Chapters;
import src.TextDisplayer;

public class TheChoice {
    public static void theChoice(String[] args) {
        String textToDisplay =
                //Create function to Describe the Pokemon
                //Create function to Choose and add the Pokemon to the Player's team
                "Professor Java: Well done , you choose your first Pokemon ! \n" +
                        "Now you need to give him a name ! \n" +
                        //Create function to Name the Pokemon
                        "You are now ready to start your adventure ! \n" +
                        "But before that, you should go to your room and take your bag \n" +
                        "And don't forget to say goodbye to your mom ! \n" ;



        TextDisplayer.displayParagraph(textToDisplay);

    }
}