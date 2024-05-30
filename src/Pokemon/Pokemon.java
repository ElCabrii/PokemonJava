package src.Pokemon;

import java.util.Scanner;

public class Pokemon {
        private String name;
        private Type.ElementType[] types;
        private Ability[] abilities;
        private int maxHP;
        private int currentHP;


        public Pokemon(String name, Type.ElementType[] types, Ability[] abilities, int maxHP) {
            this.name = name;
            this.types = types;
            this.abilities = abilities;
            this.maxHP = maxHP;
            this.currentHP = maxHP;
        }
        public String getName() {
            return name;
        }
        public Type.ElementType[] getTypes() {
            return types;
        }
        public Ability[] getAbilities() {
            return abilities;
        }
        public int getMaxHP() {
            return maxHP;
        }
        public int getCurrentHP() {
            return currentHP;
        }
        public void setCurrentHP(int currentHP) {
            this.currentHP = currentHP;
        }
        public void catchPokemon() {
            //To be implemented
            System.out.println("You caught a " + name + "!");
        }
        public void attack(Pokemon target) {
            //To be implemented
            System.out.println("What ability would you like to use?");
            for (int i = 0; i < abilities.length; i++) {
                System.out.println(i + 1 + ". " + abilities[i].getName());
            }
            Scanner choice = new Scanner(System.in);
            Ability ability = abilities[choice.nextInt() - 1];
            System.out.println(name + " used " + ability.getName() + " on " + target.getName() + "!");
        }
}
