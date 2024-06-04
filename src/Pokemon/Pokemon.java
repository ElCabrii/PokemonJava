package src.Pokemon;

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
    public Pokemon(String name, EnumTypes[] types, List<Ability> abilities, int maxHP, int attack) {
        this.name = name;
        this.types = types;
        this.abilities = abilities;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.level = 1;
        this.attack = attack;
        this.status = Status.WILD;
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

    public int attack(Pokemon target) {
        switch (status) {
            case CAUGHT -> {
                System.out.println("What ability would you like to use?");
                for (int i = 0; i < abilities.size(); i++) {
                    System.out.println(i + 1 + ". " + abilities.get(i).getName());
                }
                Scanner choice = new Scanner(System.in);
                Ability ability = abilities.get(choice.nextInt() - 1);
                System.out.println(name + " used " + ability.getName() + " on " + target.getName() + "!");
            }
            case WILD, TAMED ->
                    System.out.println(name + " used " + abilities.getFirst().getName() + " on " + target.getName() + "!");
        }
        return attack / 5;
    }
    public void faint() {
        livingStatus = LivingStatus.FAINTED;
        System.out.println(name + " has fainted!");
    }
}
