package test.pokemongame.Chapters;

import test.pokemongame.*;
import test.pokemongame.Pokemon.Status;

import java.util.Map;

public class Home {
        public static Trainer home(Trainer player) {
            String name = player.getName();
            String[] textToDisplay =
                    {       TextDisplayer.readStoryFile("data/story1/Home1"),
                            TextDisplayer.readStoryFile("data/story1/Home2")

                    };
            textToDisplay[0]=textToDisplay[0].replace("name", name);
            textToDisplay[1]=textToDisplay[1].replace("name", name);
            TextDisplayer.printWithDelay(textToDisplay[0]);
            Trainer bedrock = new Trainer("Bedrock", Map.of(City.PALLET_TOWN, Place.NURSERY));
            bedrock.addPokemonToTeam(Game.getPokemon("Rattata", Status.TAMED));
            player.fight(bedrock);
            TextDisplayer.printWithDelay(textToDisplay[1]);

            return FirstRoad.firstRoad(player);
        }
    }

