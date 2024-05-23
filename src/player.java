package src;

public class Player {
    private String name;
    private Pokemon[] team;
    private Item[] bag;
    public Player(String name, Pokemon[] team, Item[] bag) {
        this.name = name;
        this.team = team;
        this.bag = bag;
    }
    public String getName() {
        return name;
    }

}
