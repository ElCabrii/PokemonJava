package src.Pokemon;

public class Ability {
    private String name;
    private Type.ElementType type;
    private int power;
    private int maxPp;
    private int currentPp;
    public Ability(String name, Type.ElementType type, int power, int maxPp) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.maxPp = maxPp;
        this.currentPp = maxPp;
    }
    public String getName() {
        return name;
    }
    public Type.ElementType getType() {
        return type;
    }
    public int getPower() {
        return power;
    }
    public int getMaxPp() {
        return maxPp;
    }
    public int getCurrentPp() {
        return currentPp;
    }
}

