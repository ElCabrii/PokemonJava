package test.Pokemon;

import java.util.List;
import java.util.Scanner;

public class Pokemon {
    private String name;
    private EnumTypes[] types;
    private List<Ability> abilities;
    private int maxHP;
    private int currentHP;
    private int attack;
    private int level;
    private Status status;
    private LivingStatus livingStatus;
    public Pokemon(String name, EnumTypes[] types, List<Ability> abilities, int maxHP, int attack, Status status) {
        this.name = name;
        this.types = types;
        this.abilities = abilities;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.level = 1;
        this.attack = attack;
        this.status = status;
        this.livingStatus = LivingStatus.ALIVE;
    }

    public String getName() {
        return name;
    }

    public EnumTypes[] getTypes() {
        return types;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public Status getStatus() {
        return status;
    }

    public LivingStatus getLivingStatus() {
        return livingStatus;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setLivingStatus(LivingStatus livingStatus) {
        this.livingStatus = livingStatus;
    }

    public void levelUp() {
        level++;
        maxHP += 5;
        currentHP = maxHP;
        attack += 2;
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public void attack(Pokemon target) {
        switch (this.status) {
            case CAUGHT -> {
                System.out.println("What ability would you like to use?");
                for (int i = 0; i < this.abilities.size(); i++) {
                    System.out.println(i + 1 + ". " + this.abilities.get(i).getName());
                }
                Scanner choice = new Scanner(System.in);
                Ability ability = this.abilities.get(choice.nextInt() - 1);
                System.out.println(this.name + " used " + ability.getName() + " on " + target.getName() + "!");
                int dmg = this.attack/5;
                target.setCurrentHP(target.getCurrentHP() - dmg);
                System.out.println(target.getName() + " took " + dmg + " damage!");
                System.out.println(target.getName() + " has " + target.getCurrentHP() + " HP left!");
                System.out.println(target.getName() + " used " + target.getAbilities().get(0).getName() + " on " + this.name + "!");
                dmg = target.getAttack()/5;
                this.currentHP -= dmg;
                System.out.println(this.name + " took " + dmg + " damage!");
                System.out.println(this.name + " has " + this.currentHP + " HP left!");
            }
            case WILD, TAMED ->
                    System.out.println(this.name + " used " + this.abilities.get(0).getName() + " on " + target.getName() + "!");
        }
    }
    public void faint() {
        livingStatus = LivingStatus.FAINTED;
        System.out.println(name + " has fainted!");
    }
    public void heal() {
        currentHP = maxHP;
        System.out.println(name + " has been healed!");
    }
    public void revive() {
        livingStatus = LivingStatus.ALIVE;
        currentHP = maxHP/2;
        System.out.println(name + " has been revived!");
    }
    public static String randomPokemonName() {
        String[] names = { "Charmander", "Bulbasaur", "Squirtle", "Ivysaur", "Charmeleon", "Wartortle", "Venusaur", "Charizard", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate"};
        String name = names[(int) (Math.random() * names.length)];
        return name;
        }
    public static EnumTypes[] randomPokemonType() {
        EnumTypes[] types = {EnumTypes.NORMAL, EnumTypes.FIRE, EnumTypes.WATER, EnumTypes.GRASS, EnumTypes.ELECTRIC, EnumTypes.ICE, EnumTypes.FIGHTING, EnumTypes.POISON, EnumTypes.GROUND, EnumTypes.FLYING, EnumTypes.PSYCHIC, EnumTypes.BUG, EnumTypes.ROCK, EnumTypes.GHOST, EnumTypes.DRAGON, EnumTypes.DARK, EnumTypes.STEEL, EnumTypes.FAIRY};
        EnumTypes[] type = {types[(int) (Math.random() * types.length)], types[(int) (Math.random() * types.length)]};
        return type;
    }
    public static List<Ability> randomPokemonAbilities() {
        Ability[] abilities = {new Ability("Tackle", EnumTypes.NORMAL), new Ability("Scratch", EnumTypes.NORMAL), new Ability("Ember", EnumTypes.FIRE), new Ability("Water Gun", EnumTypes.WATER), new Ability("Vine Whip", EnumTypes.GRASS), new Ability("Thunder Shock", EnumTypes.ELECTRIC), new Ability("Ice Beam", EnumTypes.ICE), new Ability("Karate Chop", EnumTypes.FIGHTING), new Ability("Poison Sting", EnumTypes.POISON), new Ability("Earthquake", EnumTypes.GROUND), new Ability("Fly", EnumTypes.FLYING), new Ability("Confusion", EnumTypes.PSYCHIC), new Ability("Leech Life", EnumTypes.BUG), new Ability("Rock Throw", EnumTypes.ROCK), new Ability("Lick", EnumTypes.GHOST), new Ability("Dragon Rage", EnumTypes.DRAGON), new Ability("Dark Pulse", EnumTypes.DARK), new Ability("Iron Tail", EnumTypes.STEEL), new Ability("Dazzling Gleam", EnumTypes.FAIRY)};
        List<Ability> ability = List.of(abilities[(int) (Math.random() * abilities.length)], abilities[(int) (Math.random() * abilities.length)]);
        return ability;
    }
    public static Pokemon getPokemon(String name, Status status) {
        EnumTypes[] types = {EnumTypes.NORMAL, EnumTypes.FIRE, EnumTypes.WATER, EnumTypes.GRASS, EnumTypes.ELECTRIC, EnumTypes.ICE, EnumTypes.FIGHTING, EnumTypes.POISON, EnumTypes.GROUND, EnumTypes.FLYING, EnumTypes.PSYCHIC, EnumTypes.BUG, EnumTypes.ROCK, EnumTypes.GHOST, EnumTypes.DRAGON, EnumTypes.DARK, EnumTypes.STEEL, EnumTypes.FAIRY};
        Ability[] abilities = {new Ability("Tackle", EnumTypes.NORMAL), new Ability("Scratch", EnumTypes.NORMAL), new Ability("Ember", EnumTypes.FIRE), new Ability("Water Gun", EnumTypes.WATER), new Ability("Vine Whip", EnumTypes.GRASS), new Ability("Thunder Shock", EnumTypes.ELECTRIC), new Ability("Ice Beam", EnumTypes.ICE), new Ability("Karate Chop", EnumTypes.FIGHTING), new Ability("Poison Sting", EnumTypes.POISON), new Ability("Earthquake", EnumTypes.GROUND), new Ability("Fly", EnumTypes.FLYING), new Ability("Confusion", EnumTypes.PSYCHIC), new Ability("Leech Life", EnumTypes.BUG), new Ability("Rock Throw", EnumTypes.ROCK), new Ability("Lick", EnumTypes.GHOST), new Ability("Dragon Rage", EnumTypes.DRAGON), new Ability("Dark Pulse", EnumTypes.DARK), new Ability("Iron Tail", EnumTypes.STEEL), new Ability("Dazzling Gleam", EnumTypes.FAIRY)};
        Pokemon pokemon = new Pokemon(name, types, List.of(abilities[(int) (Math.random() * abilities.length)], abilities[(int) (Math.random() * abilities.length)]), 100, 10, status);
        return pokemon;
    }




}
