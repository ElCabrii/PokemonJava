package test;

public class Item {
    private String name;
    private String description;
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void use() {
        System.out.println("You used " + name + "!");
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

}
