package src;
import java.util.Scanner;

public class Player {
    private static String name;
    private Pokemon[] team;
    private Item[] bag;
    public Player(String name, Pokemon[] team, Item[] bag) {
        Player.name = name;
        this.team = team;
        this.bag = bag;
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

}

