package src;
import java.util.Scanner;

import src.Pokemon.Pokemon;
import src.Pokemon.Type;
import src.Pokemon.Ability;

public class Player {
    private static String name;
    private static Pokemon[] team;
    private Item[] bag;
    public Player(String name, Pokemon[] team, Item[] bag) {
        Player.name = name;
        this.team = new Pokemon[6];
        this.bag = new Item[20];
    }



    public static String getName() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Create a Player object with the provided name
        Player player = new Player(playerName, new Pokemon[6], new Item[20]);

        return playerName;


    }

    public static  void getStarterPokemon() {
        // Create Bulbasaur

        Pokemon bulbasaur = new Pokemon();

        // Create Charmander

        Pokemon charmander = new Pokemon();
        // Create Squirtle

        Pokemon squirtle = new Pokemon();
        // Add the chosen Pokemon to the player's team
        //team[0] = bulbasaur;

        //team[1] = charmander;
        //team[2] = squirtle;
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their name
        System.out.print("Choose your first Pokemon: ");
        String chosenPokemon = scanner.nextLine();
        if (chosenPokemon.equals("Bulbasaur")) {
            team[0] = bulbasaur;
        } else if (chosenPokemon.equals("Charmander")) {
            team[0] = charmander;
        } else if (chosenPokemon.equals("Squirtle")) {
            team[0] = squirtle;
        } else {
            System.out.println("Invalid choice. Please choose one of the following: Bulbasaur, Charmander, Squirtle");
            getStarterPokemon();
        }

        System.out.println("You have chosen " + team[0] + " as your first Pokemon!");
        System.out.println(team[0]);


    }

}

