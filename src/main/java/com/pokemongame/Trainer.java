package com.pokemongame;
import java.util.List;
import java.util.Scanner;

import com.pokemongame.Pokemon.Pokemon;
import com.pokemongame.Pokemon.Status;
import com.pokemongame.Pokemon.LivingStatus;

public class Trainer {
    private final String name;
    private Pokemon[] team;
    private List<Pokemon> caughtPokemon;
    private Item[] bag;
    // private Places currentLocation;

    public Trainer(String name/*, Places currentLocation*/) {
        this.name = name;
        this.team = new Pokemon[6];
        this.caughtPokemon = List.of();
        this.bag = new Item[20];
        // this.currentLocation = currentLocation;
    }

    public String getName() {
        return name;
    }

    public static Trainer askName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to continue: ");
        String playerName = scanner.nextLine();
        City location = new City("Pallet Town");
        Places currentLocation = location.getPlaces()[3];
        return new Trainer(playerName/*, currentLocation*/);
    }

    public Pokemon[] getTeam() {
        return team;
    }

    //public Places getCurrentLocation() {
    //  return currentLocation;
    //}

    public Item[] getBag() {
        return bag;
    }

    public void addPokemonToTeam(Pokemon pokemon) {
        for (int i = 0; i < team.length; i++) {
            if (team[i] == null) {
                team[i] = pokemon;
                System.out.println(name);
                System.out.println(pokemon.getName() + " has been added to " + name + "'s team!");
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
                return Game.getPokemon(chosenPokemon, Status.CAUGHT);
            }
            case "1" -> {
                return Game.getPokemon("Bulbasaur", Status.CAUGHT);
            }
            case "2" -> {
                return Game.getPokemon("Charmander", Status.CAUGHT);
            }
            case "3" -> {
                return Game.getPokemon("Squirtle", Status.CAUGHT);
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
        boolean hasAlivePokemon = false;
        for (Pokemon pokemon : team) {
            if (pokemon.getLivingStatus() == LivingStatus.ALIVE) {
                hasAlivePokemon = true;
                break;
            }
        }
        if (!hasAlivePokemon) {
            System.out.println("All of your Pokemon have fainted!");
            return null;
        } else {
            System.out.println("Choose a Pokemon!");
            for (int i = 0; i < team.length; i++) {
                if (team[i] != null) {
                    System.out.println(i + 1 + ". " + team[i].getName());
                }
            }
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            return team[choice - 1];
        }
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
        do {
            System.out.println("Go, go go " + currentPokemon.getName() + "!");
            while (currentPokemon.getCurrentHP() > 0 && oCurrentPokemon.getCurrentHP() > 0) {
                System.out.println("What would you like to do?");
                System.out.println("1. Attack");
                System.out.println("2. Switch Pokemon");
                System.out.println("3. Use Item");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> currentPokemon.attack(oCurrentPokemon);
                    case 2 -> {
                        currentPokemon = choosePokemon();
                        System.out.println("Go, go go " + currentPokemon.getName() + "!");
                    }
                    case 3 -> {
                        if (bag.length == 0) {
                            System.out.println("You have no items in your bag!");
                        } else {
                            System.out.println("What item would you like to use?");
                            for (int i = 0; i < bag.length; i++) {
                                if (bag[i] != null) {
                                    System.out.println(i + 1 + ". " + bag[i].getName());
                                }
                            }
                            int itemChoice = scanner.nextInt();
                            bag[itemChoice - 1].use();
                        }

                    }
                }
            }
            if (currentPokemon.getCurrentHP() <= 0) {
                currentPokemon.setCurrentHP(0);
                currentPokemon.faint();
                System.out.println("Choose your next Pokemon!");
                currentPokemon = choosePokemon();
            } else {
                for (int j = 0; j < opponent.getTeam().length; j++) {
                    if (oCurrentPokemon == opponent.getTeam()[j]) {
                        opponent.getTeam()[j].faint();
                        for (Pokemon pokemon : opponent.getTeam()) {
                            if (pokemon != null) {
                                if (pokemon.getLivingStatus() == LivingStatus.ALIVE) {
                                    oCurrentPokemon = pokemon;
                                    break;
                                } else {
                                    System.out.println("You win!");
                                    return;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        } while (!isFightOver(opponent));
        for (Pokemon pokemon : team) {
            if (pokemon.getCurrentHP() > 0) {
                System.out.println("You win!");
                break;
            }
            return;
        }
        System.out.println("You lose!");
    }
}
   /* public void path(){
        System.out.println(
                "In front of you, two path : \n"+
                "1. TAR \n" +
                "2. FERN\n" +
                "You have to choose which path you want to use :\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 ->
        }
    }
}*/
