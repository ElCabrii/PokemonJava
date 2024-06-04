package src;
import java.util.List;
import java.util.Scanner;

import src.Pokemon.Pokemon;

public class Trainer {
    protected static String name;
    protected static Pokemon[] team;
    protected static List<Pokemon> caughtPokemon;
    private Item[] bag;

    public Trainer(String name) {
        Trainer.name = name;
        this.team = new Pokemon[6];
        this.caughtPokemon = List.of();
        this.bag = new Item[20];
    }

    public String getName() {
        return name;
    }

    public static Trainer askName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to continue: ");
        String playerName = scanner.nextLine();
        return new Trainer(playerName);
    }

    public Pokemon[] getTeam() {
        return team;
    }

    public Item[] getBag() {
        return bag;
    }

    public void addPokemonToTeam(Pokemon pokemon) {
        for (int i = 0; i < team.length; i++) {
            if (team[i] == null) {
                team[i] = pokemon;
                System.out.println(name);
                System.out.println(pokemon.getName() + " has been added to your team!");
                return;
            }
        }
        System.out.println("What Pokemon would you like to replace with " + pokemon.getName() + "?");
        for (int i = 0; i < team.length; i++) {
            if (team[i] != null) {
                System.out.println(i + 1 + ". " + team[i].getName());
            }
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        caughtPokemon.add(team[choice - 1]);
        team[choice - 1] = pokemon;
        System.out.println(pokemon.getName() + " has been added to your team!");
    }

    public void setBag(Item[] bag) {
        this.bag = bag;
    }

    public Pokemon getStarterPokemon() {
        Scanner scanner = new Scanner(System.in);
        String chosenPokemon = scanner.nextLine();
        switch (chosenPokemon) {
            case "Bulbasaur", "Charmander", "Squirtle" -> {
                return Game.getPokemon(chosenPokemon);
            }
            default -> {
                System.out.println("Invalid choice. Please choose one of the following: Bulbasaur, Charmander, Squirtle");
                getStarterPokemon();
            }
        }

        System.out.println("You have chosen " + team[0].getName() + " as your first Pokemon!");
        return team[0];
    }

    public Pokemon choosePokemon() {
        for (int i = 0; i < team.length; i++) {
            if (team[i] != null && team[i].getCurrentHP() > 0){
                System.out.println(i + 1 + ". " + team[i].getName());
            }
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return team[choice - 1];
    }

    public void encounterPokemon(Pokemon wildPokemon) {
        System.out.println("A wild " + wildPokemon.getName() + " appeared!");

    }

    private boolean isFightOver(Trainer opponent) {
        for (Pokemon pokemon : team) {
            if (pokemon.getCurrentHP() > 0) {
                for (Pokemon oPokemon : opponent.getTeam()) {
                    if (oPokemon.getCurrentHP() > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void fight(Trainer opponent) {
        System.out.println("You are fighting " + opponent.getName() + "!");
        Pokemon currentPokemon = team[0];
        System.out.println("Current Pokemon: " + currentPokemon.getName());
        Pokemon oCurrentPokemon = opponent.getTeam()[0];
        System.out.println("Opponent's current Pokemon: " + oCurrentPokemon.getName());
        /*
        do {
            System.out.println("Go, go go " + currentPokemon.getName() + "!");
            while (currentPokemon.getCurrentHP() > 0 && oCurrentPokemon.getCurrentHP() > 0) {
                int dmg = currentPokemon.attack(oCurrentPokemon);
                oCurrentPokemon.setCurrentHP(oCurrentPokemon.getCurrentHP() - dmg);
                System.out.println(oCurrentPokemon.getName() + " took " + dmg + " damage!");
                dmg = oCurrentPokemon.attack(currentPokemon);
                currentPokemon.setCurrentHP(currentPokemon.getCurrentHP() - dmg);
                System.out.println(currentPokemon.getName() + " took " + dmg + " damage!");
            }
            if (currentPokemon.getCurrentHP() <= 0) {
                currentPokemon.setCurrentHP(0);
                currentPokemon.faint();
                System.out.println("Choose your next Pokemon!");
                currentPokemon = choosePokemon();
            } else {
                oCurrentPokemon.setCurrentHP(0);
                oCurrentPokemon.faint();
                for (int j = 0; j < opponent.getTeam().length; j++) {
                    if (oCurrentPokemon == opponent.getTeam()[j]) {
                        opponent.getTeam()[j] = null;
                        oCurrentPokemon = opponent.getTeam()[j+1];
                        break;
                    }
                }

            }
        } while (!isFightOver(opponent));*/
    }
}
