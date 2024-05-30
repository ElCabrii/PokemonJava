package src;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import src.Pokemon.Ability;
import src.Pokemon.Pokemon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class game {
    static List<Pokemon> pokemons = new ArrayList<>();

    static void readFromJson() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray pokemonList = (JSONArray) parser.parse(new FileReader("src/pokemons.json"));

        pokemonList.forEach(o -> {
            JSONObject json = (JSONObject) o;
            JSONArray abilities = (JSONArray) json.get("abilities");
            final List<Ability> abilitiesList = new ArrayList<>();
            abilities.forEach(a -> {
                String ability = (String) a;
                abilitiesList.add(new Ability(ability, null));
            });
            final int hp = (int) ((JSONObject) json.get("stats")).get("hp");
            final Pokemon pokemon = new Pokemon((String) json.get("name"), null, abilitiesList, hp);
            pokemons.add(pokemon);
        });
    }

}
