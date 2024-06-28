package com.pokemongame;

import com.pokemongame.Pokemon.*;

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
    public Boolean hasItem(Item[] bag) {
        for (Item item : bag) {
            if (item.getName() == name) {
                return true;
            }
        }
        return false;
    }
    public void removeItem(Item[] bag) {
        for (Item item : bag) {
            if (item.getName() == name) {
                item.setAmount(item.getAmount() - 1);
            }
        }
    }
    public void use(Pokemon[] Team, Item[] Bag){
        System.out.println("You used " + name + "!");
        switch (name) {
            case POTION:
                if (!hasItem(Bag)){
                    System.out.println("You don't have any potions!");
                    break;
                }
                System.out.println("Which Pokemon would you like to heal?");
                for (int i = 0; i < Team.length; i++) {
                    System.out.println(i + 1 + ". " + Team[i].getName());
                }
                int choice = 0;
                Scanner input = new Scanner(System.in);
                while (choice < 1 || choice > Team.length) {
                    System.out.println("Invalid choice. Please choose a number between 1 and " + Team.length);
                    choice = input.nextInt();
                }
                while (Team[choice - 1].getCurrentHP() < 0 || Team[choice - 1].getCurrentHP() > Team[choice - 1].getMaxHP()) {
                    System.out.println("You can't heal that pokemon !");
                    choice = input.nextInt();
                }
                Team[choice - 1].setCurrentHP(Team[choice - 1].getCurrentHP() + 20);
                System.out.println("You healed your Pokemon!");
                removeItem(Bag);
                break;
            case REVIVE:
                if (!hasItem(Bag)){
                    System.out.println("You don't have any revives!");
                    break;
                }
                System.out.println("Which Pokemon would you like to revive?");
                for (int i = 0; i < Team.length; i++) {
                    System.out.println(i + 1 + ". " + Team[i].getName());
                }
                choice = 0;
                input = new Scanner(System.in);
                while (choice < 1 || choice > Team.length) {
                    System.out.println("Invalid choice. Please choose a number between 1 and " + Team.length);
                    choice = input.nextInt();
                }
                while (Team[choice - 1].getLivingStatus() != LivingStatus.FAINTED) {
                    System.out.println("You can't revive that pokemon !");
                    choice = input.nextInt();
                }
                Team[choice - 1].revive();
                System.out.println("You revived your Pokemon!");
                removeItem(Bag);
                break;
            case POKEBALL:
                if (!hasItem(Bag)){
                    System.out.println("You don't have any pokeballs!");
                    break;
                }
                removeItem(Bag);
            default:
                break;
        }
    }
}
