package src;

public class player {
    private String name;
    private pokemon[] team;
    private item[] bag;
    public player(String name, pokemon[] team, item[] bag) {
        this.name = name;
        this.team = team;
        this.bag = bag;
    }
    public String getName() {
        return name;
    }

}
