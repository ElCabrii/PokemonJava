package test.pokemongame;

import test.pokemongame.Pokemon.LivingStatus;
import test.pokemongame.Pokemon.Pokemon;
import test.pokemongame.Pokemon.Status;

import java.util.*;

import static com.pokemongame.TextDisplayer.printWithDelay;

public class Trainer {
    private final String name;
    private Pokemon[] team;
    private List<Pokemon> caughtPokemon;
    private Item[] bag;
    private static List<City> cities= new ArrayList<>();
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
                    System.out.println(i + ". " + team[i].getName());
                }
            }
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (team[choice - 1].getLivingStatus() == LivingStatus.FAINTED) {
                System.out.println("This Pokemon has fainted! Choose another one.");
                return choosePokemon();
            } else {
                System.out.println("You chose " + team[choice - 1].getName() + "!");
                return team[choice - 1];
            }
        }
    }

    public void encounterPokemon(Pokemon wildPokemon) {
        System.out.println("What would you like to do?");
        System.out.println("1. Fight");
        System.out.println("2. Catch");
        System.out.println("3. Run");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                Pokemon currentPokemon = choosePokemon();
                if (currentPokemon != null) {
                    currentPokemon.attack(wildPokemon);
                }
            }
            case 2 -> {
                if (wildPokemon.getCurrentHP() < wildPokemon.getMaxHP() / 2) {
                    System.out.println("You throw a pokeball at " + wildPokemon.getName() + "!");

                    System.out.println("You caught " + wildPokemon.getName() + "!");
                    caughtPokemon.add(wildPokemon);
                } else {
                    System.out.println("You throw a pokemon at " + wildPokemon.getName() + "!");
                    System.out.println(wildPokemon.getName() + " escaped! You need to weaken it first.");
                    encounterPokemon(wildPokemon);
                }

            }
            case 3 -> System.out.println("You ran away!");
        }
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
        return !alliedAlive || !opponentAlive;
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
                            bag[itemChoice - 1].use(team, bag);
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


    public void choosePath(City targetCity, City previousCity, City nextCity) {
        City currentCity = currentLocation.keySet().iterator().next();
        Random random = new Random();
        int fightChance = random.nextInt(100); // Generates a random number between 0 and 99
        int fightProbability = 50; // Set the probability of encountering a fight to 50%

        System.out.println(
                """
                        There are two paths in front of you :\s
                        1. TAR\s
                        2. FERN
                        You have to choose which path you want to use :
                        """);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                TextDisplayer.printWithDelay("You choose the TAR path");
               /* if (fightChance < fightProbability) { // 50% chance to encounter a Trainer
                    TextDisplayer.printWithDelay("You encounter a Trainer!");
                    Trainer randomTrainer = new Trainer("Trainer", Map.of(City.PALLET_TOWN, Place.NURSERY));
                    randomTrainer.addPokemonToTeam(Game.getRandomPokemon(Status.TAMED));
                    fight(randomTrainer);
                } else { // 50% chance to go directly to the next village
                   */ TextDisplayer.printWithDelay("You safely reach the next village without any encounters.");
                    moveToCity(targetCity, previousCity, nextCity);
                }

            case 2 -> {
                TextDisplayer.printWithDelay("You choose the FERN path");
               /* if (fightChance < fightProbability) { // 50% chance to encounter a wild Pokémon
                    TextDisplayer.printWithDelay("You encounter a wild Pokemon!");
                    Pokemon randomPokemon = Game.getRandomPokemon(Status.WILD);
                    encounterPokemon(randomPokemon);
                    Pokemon wildPokemon = Game.getPokemon(randomPokemon.randomPokemonName(), Status.WILD);
                    Pokemon currentPokemon = team[0];
                    currentPokemon.attack(wildPokemon);
                } else { // 50% chance to go directly to the next village
                 */   TextDisplayer.printWithDelay("You safely reach the next village without any encounters.");
                    moveToCity(targetCity, previousCity, nextCity);
                }

            default -> {
                System.out.println("Invalid choice. Please choose 1 or 2.");
                choosePath(targetCity, previousCity, nextCity);
            }
        }
    }

    private void moveToCity(City city, City previousCity, City nextCity) {
        TextDisplayer.printWithDelay("You have reached " + city.name() + ".");
        currentLocation = Map.of(city, Place.NURSERY); // Update current location
        enterCity(city, previousCity, nextCity);
    }

    private void enterCity(City city, City previousCity, City nextCity) {
        System.out.println(
                """
                        You have the following options in %s :\s
                        1. Enter the Pokémon Center\s
                        2. Visit the Shop\s
                        3. Challenge the Arena\s
                        4. Go to the next city\s
                        5. Return to the previous city
                        """.formatted(city.name()));
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                TextDisplayer.printWithDelay("You enter the Pokémon Center.");
                // Logic for Pokémon Center
            }
            case 2 -> {
                TextDisplayer.printWithDelay("You visit the Shop.");
                // Logic for Shop
            }
            case 3 -> {
                TextDisplayer.printWithDelay("You challenge the Arena.");
                // Logic for Arena
            }
            case 4 -> {
                if (nextCity != null) {
                    TextDisplayer.printWithDelay("You head to the next city.");
                    choosePath(nextCity, city, getNextCity(nextCity));
                } else {
                    TextDisplayer.printWithDelay("There is no next city.");
                    enterCity(city, previousCity, nextCity);
                }
            }
            case 5 -> {
                if (previousCity != null) {
                    TextDisplayer.printWithDelay("You return to the previous city.");
                    choosePath(previousCity, getPreviousCity(previousCity), city);
                } else {
                    TextDisplayer.printWithDelay("There is no previous city.");
                    enterCity(city, previousCity, nextCity);
                }
            }
            default -> {
                System.out.println("Invalid choice. Please choose 1, 2, 3, 4, or 5.");
                enterCity(city, previousCity, nextCity);
            }
        }
    }

    private City getNextCity(City currentCity) {
        int currentIndex = cities.indexOf(currentCity);
        if (currentIndex >= 0 && currentIndex < cities.size() - 1) {
            return cities.get(currentIndex + 1);
        } else {
            return null; // No next city
        }
    }

    private City getPreviousCity(City currentCity) {
        int currentIndex = cities.indexOf(currentCity);
        if (currentIndex > 0 && currentIndex < cities.size()) {
            return cities.get(currentIndex - 1);
        } else {
            return null; // No previous city
        }
    }


    public void giveItem(Item item, int amount) {
        for (int i = 0; i < bag.length; i++) {
            if (bag[i] != null && bag[i].getName().equals(item.getName())) {
                bag[i].setAmount(bag[i].getAmount() + amount);
                System.out.println("You received " + amount + item.getName() + "!");
                return;
            } else if (bag[i] == null) {
                item.setAmount(amount);
                bag[i] = item;
                System.out.println("You received " + amount + item.getName() + "!");
                return;
            }
        }
        System.out.println("Your bag is full! You can't receive " + item.getName() + "!");
    }

}