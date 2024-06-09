package com.pokemongame;

import java.util.Random;
import com.pokemongame.Pokemon.Pokemon;

public class RandomChoice {
        public static Object randomPathEvent(City name, Object object){
            if (!((object instanceof Trainer) || (object instanceof Pokemon))) {
                throw new IllegalArgumentException("The object must be either a Trainer or a Pokemon");
            }
            /*Random random = new Random();
            // Générer un nombre aléatoire entre 0 et 1
            double randomValue = random.nextDouble();
            // Vérifier si ce nombre est inférieur à 2/3 (0.6667)
            if (randomValue < (2.0 / 3.0)) {
                return object;
            } else {
                return name;
            }*/
            return object;
        }
}
