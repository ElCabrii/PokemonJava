package com.pokemongame.Chapters;
import com.pokemongame.TextDisplayer;
import com.pokemongame.Trainer;

import java.util.Scanner;


public class TheChoice {
    public static Trainer theChoice(Trainer trainer) {
        System.out.print("Choose your first Pokemon: ");
        trainer.addPokemonToTeam(trainer.getStarterPokemon());
        String[] textToDisplay =
                {"Professor Java: Well done , you chose your first Pokemon ! \n" +
                        "Now you need to give him a name ! \n",
                        "You are now ready to start your adventure ! \n" +
                        "But before that, you should go to your room and take your stuff. \n" +
                        "And don't forget to say goodbye to your mom ! \n"} ;
        TextDisplayer.displayParagraph(textToDisplay[0]);
        System.out.print("Enter a name for your Pokemon: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        trainer.getTeam()[0].setName(name);
        TextDisplayer.displayParagraph(textToDisplay[1]);
        return Home.home(trainer);
    }
}