package src.Chapters;
import src.Move;
import src.TextDisplayer;
import src.Player;


public class TheChoice {
    public static void theChoice(String[] args) {
        String textToDisplay =
                "Professor Java: Well done , you choose your first Pokemon ! \n" +
                        "Now you need to give him a name ! \n" +
                        //Create function to Name the Pokemon
                        "You are now ready to start your adventure ! \n" +
                        "But before that, you should go to your room and take your bag \n" +
                        "And don't forget to say goodbye to your mom ! \n" ;

        //Create function to Choose and add the Pokemon to the Player's team
        Player.getStarterPokemon();

        TextDisplayer.displayParagraph(textToDisplay);

        String destination1 = "Home";
        String destination2 = "Laboratory";
        Move.move(destination1, destination2);
    }
}