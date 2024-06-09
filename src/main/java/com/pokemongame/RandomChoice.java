package com.pokemongame;

import java.util.Random;

public class RandomChoice {
        public static Object randomTar(City name, Object trainer) {
            Random random = new Random();
            // Générer un nombre aléatoire entre 0 et 1
            double randomValue = random.nextDouble();

            // Vérifier si ce nombre est inférieur à 2/3 (0.6667)
            if (randomValue < (2.0 / 3.0)) {
                return trainer;
            } else {
                return name;
            }
        }
        public static Object randomFern(City name, Object randomPokemon){
            Random random = new Random();
            // Générer un nombre aléatoire entre 0 et 1
            double randomValue = random.nextDouble();

            // Vérifier si ce nombre est inférieur à 2/3 (0.6667)
            if (randomValue < (2.0 / 3.0)) {
                return randomPokemon;
            } else {
                return name;
            }
        };

}
