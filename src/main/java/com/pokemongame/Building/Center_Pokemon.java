package com.pokemongame.Building;

import com.pokemongame.City;
import com.pokemongame.TextDisplayer;
import java.util.Scanner;

public class Center_Pokemon {
    private City city;
    private City previousCity;
    private City nextCity;
    private Scanner scan;

    public Center_Pokemon(City city, City previousCity, City nextCity) {
        this.city = city;
        this.previousCity = previousCity;
        this.nextCity = nextCity;
        this.scan = new Scanner(System.in);

        TextDisplayer.printWithDelay("Welcome to the Pokemon Center!");
        TextDisplayer.printWithDelay("Would you like to heal your Pokemon?");
        TextDisplayer.printWithDelay("1. Yes");
        TextDisplayer.printWithDelay("2. No");

        int choice = scan.nextInt();
        if (choice == 1) {
            healPokemon();
            TextDisplayer.printWithDelay("Your Pokemon have been healed!");
            enterCity(city, previousCity, nextCity);
        }
        else {
            TextDisplayer.printWithDelay("Thank you for visiting the Pokemon Center!");
            enterCity(city, previousCity, nextCity);
        }
    }

    private void healPokemon() {
        // Add your healing logic here
    }

    private void enterCity(City city, City previousCity, City nextCity) {
        TextDisplayer.printWithDelay("Where would you like to go?");
        TextDisplayer.printWithDelay("1. " + previousCity.getName());
        TextDisplayer.printWithDelay("2. " + nextCity.getName());

        int choice = scan.nextInt();
        if (choice == 1) {
            city.enterCity(previousCity, city, nextCity);
        }
        else {
            city.enterCity(nextCity, previousCity, city);

        }
    }
}