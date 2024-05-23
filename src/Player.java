package src;

public class Player {
    private String name;
    private Pokemon[] team;
    private Item[] bag;
    public Player(String name, Pokemon[] team, Item[] bag) {
        this.name = name;
        this.team = team;
        this.bag = bag;
        this.team = new Pokemon[6];
        this.bag = new Item[20];
    }
    public String getName() {
        return name;
    }

}
