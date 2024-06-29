package test.pokemongame.Chapters;
import test.pokemongame.TextDisplayer;
import test.pokemongame.Trainer;

import java.util.Scanner;


public class TheChoice {
    public static Trainer theChoice(Trainer trainer) {
        trainer.addPokemonToTeam(trainer.getStarterPokemon());
        String[] textToDisplay =
                {       TextDisplayer.readStoryFile("data/story1/TheChoice1"),
                        TextDisplayer.readStoryFile("data/story1/TheChoice2")

                } ;
        TextDisplayer.printWithDelay(textToDisplay[0]);
        System.out.print("Enter a name for your Pokemon: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        trainer.getTeam()[0].setName(name);
        TextDisplayer.printWithDelay(textToDisplay[1]);
        return Home.home(trainer);
    }
}