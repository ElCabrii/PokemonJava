package com.pokemongame.Building;

import com.pokemongame.City;
import com.pokemongame.TextDisplayer;
import com.pokemongame.ItemEnum;
import com.pokemongame.Trainer;

import java.util.Scanner;

public class Shop {
    private Scanner scan;
    private Trainer player;

    public Shop (Trainer player) {
        this.player = player;
    }

    public void buyItem() {
        this.scan = new Scanner(System.in);
        player.showBagContents();
        TextDisplayer.printWithDelay("You are in the shop. What would you like to buy?");
        TextDisplayer.printWithDelay("1. Potion");
        TextDisplayer.printWithDelay("2. Revive");
        TextDisplayer.printWithDelay("3. Pokeball");
        TextDisplayer.printWithDelay("4. Exit");

        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                buyPotion();
                break;
            case 2:
                buyRevive();
                break;
            case 3:
                buyPokeball();
                break;
            case 4:
                TextDisplayer.printWithDelay("Thank you for visiting the shop!");
                break;
            default:
                TextDisplayer.printWithDelay("Invalid choice. Please try again.");
                buyItem();
        }
    }

    private void buyPotion() {
        player.addItem(ItemEnum.POTION);
        player.showBagContents();
        player.enterCity(player.getCurrentCity(), player.getPreviousCity(player.getCurrentCity()), player.getNextCity(player.getCurrentCity()));

    }

    private void buyRevive() {
        player.addItem(ItemEnum.REVIVE);
        player.showBagContents();
        player.enterCity(player.getCurrentCity(), player.getPreviousCity(player.getCurrentCity()), player.getNextCity(player.getCurrentCity()));

    }

    private void buyPokeball() {
        player.addItem(ItemEnum.POKEBALL);
        player.showBagContents();
        player.enterCity(player.getCurrentCity(), player.getPreviousCity(player.getCurrentCity()), player.getNextCity(player.getCurrentCity()));

    }
}