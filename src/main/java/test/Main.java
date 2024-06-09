package test;

import org.json.simple.parser.ParseException;
import test.Chapters.FirstRoad;
import test.Pokemon.Ability;
import test.Pokemon.EnumTypes;
import test.Pokemon.Pokemon;
import test.Pokemon.Status;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Game.readFromJson();

        Trainer player = Trainer.askName();

            Pokemon pokemon = new Pokemon("Charmander", new EnumTypes[]{EnumTypes.FIRE}, List.of(new Ability("Ember", EnumTypes.FIRE), new Ability("Scratch", EnumTypes.NORMAL)), 100, 10, Status.NORMAL);
            Pokemon target = new Pokemon("Bulbasaur", new EnumTypes[]{EnumTypes.GRASS, EnumTypes.POISON}, List.of(new Ability("Vine Whip", EnumTypes.GRASS), new Ability("Tackle", EnumTypes.NORMAL)), 100, 10, Status.NORMAL);
            pokemon.attack(target);



        FirstRoad.firstRoad(player, "Pallet Town");
    }
}
