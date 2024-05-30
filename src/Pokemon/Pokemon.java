package src.Pokemon;

enum Type {
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    DARK,
    STEEL,
    FAIRY
}

public class Pokemon {
        private String name;
        private Type[] types;
        private Ability[] abilities;
        private int maxHP;
        private int currentHP;
}
