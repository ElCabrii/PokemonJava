package com.pokemongame;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.pokemongame.Chapters.Intro;
import com.pokemongame.Pokemon.Ability;
import com.pokemongame.Pokemon.Pokemon;
import com.pokemongame.Pokemon.Status;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Game {
    static List<Pokemon> pokemons = new ArrayList<>();
    public Trainer trainer;
    public Game(Trainer trainer) {
        this.trainer = trainer;
    }
    static void readFromJson() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray pokemonList = (JSONArray) parser.parse(new FileReader("data/pokemons.json"));

        pokemonList.forEach(o -> {
            JSONObject json = (JSONObject) o;
            JSONArray abilities = (JSONArray) json.get("abilities");
            final List<Ability> abilitiesList = new ArrayList<>();
            abilities.forEach(a -> {
                String ability = (String) a;
                abilitiesList.add(new Ability(ability, null));
            });
            final int hp = Integer.parseInt((String) json.get("hp"));
            final int attack = Integer.parseInt((String) json.get("attack"));
            final Pokemon pokemon = new Pokemon((String) json.get("name"), null, abilitiesList, hp, attack, null);
            pokemons.add(pokemon);
        });
    }
    public static Pokemon getPokemon(String name, Status status) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName().equals(name)) {
                pokemon.setStatus(status);
                return pokemon;
            }
        }
        return null;
    }
    public static Pokemon getRandomPokemon(Status status) {
        Pokemon pokemon = pokemons.get((int) (Math.random() * pokemons.size()));
        pokemon.setStatus(status);
        return pokemon;
    }
    public Trainer getPlayer() {
        return trainer;
    }
    static Trainer start(){
        return Intro.start();
    }

}
