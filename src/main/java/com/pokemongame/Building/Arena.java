package com.pokemongame.Building;

import com.pokemongame.*;
import com.pokemongame.Chapters.Nextstep;
import com.pokemongame.Pokemon.Status;

import java.util.Map;
import java.util.Scanner;

public class Arena {
    public Arena(Trainer player) {
        TextDisplayer.printWithDelay("Welcome to the Pokemon Arena!");
        TextDisplayer.printWithDelay("Would you like to battle?");
        TextDisplayer.printWithDelay("1. Yes");
        TextDisplayer.printWithDelay("2. No");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please choose 1 or 2.");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            TextDisplayer.printWithDelay("You have chosen to battle!");
            TextDisplayer.printWithDelay("You have to win 3 fights to win the game!");
            int battlesWon = 0;
            // Initialize trainers
            Trainer minion1 = new Trainer("Minion 1", Map.of(City.PALLET_TOWN, Place.NURSERY));
            minion1.addPokemonToTeam(Game.getPokemon("Caterpie", Status.TAMED));

            if (player.fight(minion1)) {
                battlesWon++;
            }
            Trainer minion2 = new Trainer("Minion 2", Map.of(City.PALLET_TOWN, Place.NURSERY));
            minion2.addPokemonToTeam(Game.getPokemon("Metapod", Status.TAMED));

            if (player.fight(minion2)) {
                battlesWon++;
            }
            Trainer minion3 = new Trainer("Minion 3", Map.of(City.PALLET_TOWN, Place.NURSERY));
            minion3.addPokemonToTeam(Game.getPokemon("Weedle", Status.TAMED));

            if (player.fight(minion3)) {
                battlesWon++;
            }

            // Check if player won all battles
            if (battlesWon == 3) {
                TextDisplayer.printWithDelay("Congratulations! You won all the battles and earned a badge!");
                player.addBadge(new Badge("Arena Badge"));
                Nextstep.nextStep(player);
            } else {
                TextDisplayer.printWithDelay("You lost one or more battles. Better luck next time!");
            }

        } else {
            TextDisplayer.printWithDelay("Thank you for visiting the Pokemon Arena!");
        }
    }
}
