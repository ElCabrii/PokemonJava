package src;

import src.Pokemon.*;
import src.Chapters.*;

import static src.Pokemon.Type.ElementType.*;


public class Main {
    public static void main(String[] args) {
        Pokemon Pikachu = new Pokemon("Pikachu", new Type.ElementType[]{ELECTRIC}, new Ability[]{new Ability("Thunder Shock", ELECTRIC, 40, 30)}, 35);
        Pokemon Bulbasaur = new Pokemon("Bulbasaur", new Type.ElementType[]{GRASS, POISON}, new Ability[]{new Ability("Vine Whip", GRASS, 45, 25)}, 45);
        Pikachu.attack(Bulbasaur);
    }
}
