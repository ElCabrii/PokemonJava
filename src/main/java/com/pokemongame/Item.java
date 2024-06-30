package com.pokemongame;

import com.pokemongame.Pokemon.LivingStatus;
import com.pokemongame.Pokemon.Pokemon;

import java.util.Scanner;

public class Item {
    private final ItemEnum name;
    private int amount;

    public Item(ItemEnum name) {
        this.name = name;
        amount = 0;
    }

    public ItemEnum getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean hasItem(Item[] bag) {
        for (Item item : bag) {
            if (item.getName() == name && item.getAmount() > 0) {
                return true;
            }
        }
        return false;
    }

    public void removeItem(Item[] bag) {
        for (Item item : bag) {
            if (item.getName() == name && item.getAmount() > 0) {
                item.setAmount(item.getAmount() - 1);
                break;
            }
        }
    }

    public void use(Pokemon[] team, Item[] bag) {
        System.out.println("You used " + name + "!");
        switch (name) {
            case POTION:
                if (!hasItem(bag)) {
                    System.out.println("You don't have any potions!");
                    break;
                }
                System.out.println("Which Pokemon would you like to heal?");
                for (int i = 0; i < team.length; i++) {
                    System.out.println((i + 1) + ". " + team[i].getName());
                }
                int choice = 0;
                Scanner input = new Scanner(System.in);
                while (choice < 1 || choice > team.length) {
                    System.out.println("Invalid choice. Please choose a number between 1 and " + team.length);
                    choice = input.nextInt();
                }
                while (team[choice - 1].getCurrentHP() <= 0 || team[choice - 1].getCurrentHP() >= team[choice - 1].getMaxHP()) {
                    System.out.println("You can't heal that pokemon!");
                    choice = input.nextInt();
                }
                team[choice - 1].setCurrentHP(team[choice - 1].getCurrentHP() + 20);
                System.out.println("You healed your Pokemon!");
                removeItem(bag);
                break;
            case REVIVE:
                if (!hasItem(bag)) {
                    System.out.println("You don't have any revives!");
                    break;
                }
                System.out.println("Which Pokemon would you like to revive?");
                for (int i = 0; i < team.length; i++) {
                    System.out.println((i + 1) + ". " + team[i].getName());
                }
                choice = 0;
                input = new Scanner(System.in);
                while (choice < 1 || choice > team.length) {
                    System.out.println("Invalid choice. Please choose a number between 1 and " + team.length);
                    choice = input.nextInt();
                }
                while (team[choice - 1].getLivingStatus() != LivingStatus.FAINTED) {
                    System.out.println("You can't revive that pokemon!");
                    choice = input.nextInt();
                }
                team[choice - 1].revive();
                System.out.println("You revived your Pokemon!");
                removeItem(bag);
                break;
            case POKEBALL:
                if (!hasItem(bag)) {
                    System.out.println("You don't have any pokeballs!");
                    break;
                }
                removeItem(bag);
                // Logique d'utilisation des Pokeballs peut être ajoutée ici
                break;
            default:
                break;
        }
    }
}
