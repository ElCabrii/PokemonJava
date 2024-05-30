package src.Pokemon;

public class Ability {
    private String name;
    private Type.ElementType type;
    public Ability(String name, Type.ElementType type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public Type.ElementType getType() {
        return type;
    }
}

