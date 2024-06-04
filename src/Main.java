package src;

import org.json.simple.parser.ParseException;
import src.Chapters.*;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Game.readFromJson();
        //Trainer player = Game.start();
        Trainer player = new Trainer("Gabriel");
        player.addPokemonToTeam(Game.getPokemon("Bulbasaur"));
        Trainer opponent = new Trainer("Opponent");
        opponent.addPokemonToTeam(Game.getPokemon("Charmander"));
        System.out.println(player.getName());
        System.out.println(player.getTeam()[0].getName());
        //player.fight(opponent);
    }
}
