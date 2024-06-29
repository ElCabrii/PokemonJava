package test.pokemongame.Pokemon;

public class Ability {
    private String name;
    private EnumTypes type;
    public Ability(String name, EnumTypes type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public EnumTypes getType() {
        return type;
    }
}

