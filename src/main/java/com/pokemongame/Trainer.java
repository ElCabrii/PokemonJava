package com.pokemongame;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.pokemongame.Pokemon.Pokemon;
import com.pokemongame.Pokemon.Status;
import com.pokemongame.Pokemon.LivingStatus;

import static com.pokemongame.TextDisplayer.printWithDelay;

public class Trainer {
    private final String name;
    private Pokemon[] team;
    private List<Pokemon> caughtPokemon;
    private Item[] bag;
    private Map<City, Place> currentLocation;
    // private Places currentLocation;

    public Trainer(String name, Map<City, Place> currentLocation) {
        this.name = name;
        this.team = new Pokemon[6];
        this.caughtPokemon = List.of();
        this.bag = new Item[20];
        this.currentLocation = currentLocation;
    }

    public String getName() {
        return name;
    }

    public static Trainer askName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to continue: ");
        String playerName = scanner.nextLine();
        return new Trainer(playerName, Map.of(City.PALLET_TOWN, Place.NURSERY));
    }

    public Pokemon[] getTeam() {
        return team;
    }

    public Map<City, Place> getCurrentLocation() {
        return currentLocation;
    }

    public Item[] getBag() {
        return bag;
    }

    public void addPokemonToTeam(Pokemon pokemon) {
        for (int i = 0; i < team.length; i++) {
            if (team[i] == null) {
                team[i] = pokemon;
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
        System.out.println("Make your choice: ");
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
                System.out.println("Invalid choice. Please try again");
                getStarterPokemon();
            }
        }

        System.out.println("You have chosen " + team[0].getName() + " as your first Pokemon!");
        return team[0];
    }

    public Pokemon choosePokemon() {
        boolean hasAlivePokemon = false;
        for (Pokemon pokemon : team) {
            if (pokemon != null) {
                if (pokemon.getLivingStatus() == LivingStatus.ALIVE) {
                    hasAlivePokemon = true;
                    break;
                }
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
        boolean alliedAlive = false;
        boolean opponentAlive = false;
        for (Pokemon pokemon : team) {
            if (pokemon != null) {
                if (pokemon.getLivingStatus() == LivingStatus.ALIVE) {
                    alliedAlive = true;
                    break;
                }
            }
        }
        for (Pokemon pokemon : opponent.getTeam()) {
            if (pokemon != null) {
                if (pokemon.getLivingStatus() == LivingStatus.ALIVE) {
                    opponentAlive = true;
                    break;
                }
            }
        }
        return !alliedAlive && !opponentAlive;
    }

    public void fight(Trainer opponent) {
        printWithDelay("You are fighting " + opponent.getName() + "!");
        Pokemon currentPokemon = team[0];
        printWithDelay("Current Pokemon: " + currentPokemon.getName());
        Pokemon oCurrentPokemon = opponent.getTeam()[0];
        printWithDelay("Opponent's current Pokemon: " + oCurrentPokemon.getName());
        do {
            printWithDelay("Go, go go " + currentPokemon.getName() + "!");
            while (currentPokemon.getCurrentHP() > 0 && oCurrentPokemon.getCurrentHP() > 0) {
                printWithDelay("What would you like to do?");
                printWithDelay("1. Attack");
                printWithDelay("2. Switch Pokemon");
                printWithDelay("3. Use Item");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> currentPokemon.attack(oCurrentPokemon);
                    case 2 -> {
                        currentPokemon = choosePokemon();
                        printWithDelay("Go, go go " + currentPokemon.getName() + "!");
                    }
                    case 3 -> {
                        if (bag.length == 0) {
                            printWithDelay("You have no items in your bag!");
                        } else {
                            printWithDelay("What item would you like to use?");
                            for (int i = 0; i < bag.length; i++) {
                                if (bag[i] != null) {
                                    printWithDelay((i + 1) + ". " + bag[i].getName());
                                }
                            }
                            int itemChoice = scanner.nextInt();
                            bag[itemChoice - 1].use();
                        }
                    }
                }
            }
            if (currentPokemon.getLivingStatus() == LivingStatus.FAINTED) {
                currentPokemon = choosePokemon();
            } else {
                for (int j = 0; j < opponent.getTeam().length; j++) {
                    if (oCurrentPokemon == opponent.getTeam()[j]) {
                        for (Pokemon pokemon : opponent.getTeam()) {
                            if (pokemon != null) {
                                if (pokemon.getLivingStatus() == LivingStatus.ALIVE) {
                                    oCurrentPokemon = pokemon;
                                    break;
                                } else {
                                    printWithDelay("You win!");
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
                printWithDelay("You win!");
                break;
            }
            return;
        }
        printWithDelay("You lose!");
    }


    public void choosePath() {
        City city = currentLocation.keySet().iterator().next();

        System.out.println(
                """
                        There are two path in front of you :\s
                        1. TAR\s
                        2. FERN
                        You have to choose which path you want to use :
                        """);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("You choose the TAR path");
                RandomChoice.randomPathEvent(city, this);
            }
            case 2 -> {
                System.out.println("You choose the FERN path");
                Pokemon randomPokemon = Game.getRandomPokemon(Status.WILD);
                RandomChoice.randomPathEvent(city, randomPokemon);
            }
        }
    }
}
