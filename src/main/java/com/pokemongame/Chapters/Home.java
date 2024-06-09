package com.pokemongame.Chapters;

import com.pokemongame.*;
import com.pokemongame.Pokemon.Status;

import java.util.Map;

public class Home {
        public static Trainer home(Trainer player) {
            String name = player.getName();
            String[] textToDisplay =
                    {"You go back to your house. \n" +
                            "Your mom is waiting for you. \n" +
                            "Mom: Hi honey, how was your day ? \n" +
                            name + ": It was great mom, I chose my first Pokemon ! \n" +
                            "Now I am going to begin my travel! \n" +
                            "Say bye to papa for me! \n"+
                            "Mom: I will honey, take care of yourself and your Pokemon! \n" +
                            name + ": I will mom, I promise! \n" +
                            "You start to move towards the street. \n" +
                            "You see your rival waiting for you. \n" +
                            "Bedrock: Hey, I was waiting for you! \n" +
                            name +": Hey, what's up? \n" +
                            "Bedrock: I am going to be the best Pokemon trainer! \n" +
                            "I will beat you and become the champion! \n" +
                            name + ": We will see about that! \n" +
                            "Bedrock: Let's battle! \n",
                            name +": You see, i'm already better! \n"+
                            "Bedrock: Ok for this time but next time will be deferent !!! \n" +
                            "Bedrock : CIAO ! \n"+
                            "You start to walk through the village.\n"+
                            "When you pass, everyone greets you and wishes you good luck on your trip.\n"+
                            "You start to feel a bit strange, adrenalin of becoming an adult and travel alone circulate your veins.\n"+
                            "it's the beginning of your adventure !!!\n "
                    };

            TextDisplayer.printWithDelay(textToDisplay[0]);
            Trainer bedrock = new Trainer("Bedrock", Map.of(City.PALLET_TOWN, Place.NURSERY));
            bedrock.addPokemonToTeam(Game.getPokemon("rattata", Status.TAMED));
            player.fight(bedrock);
            TextDisplayer.printWithDelay(textToDisplay[1]);

            return FirstRoad.firstRoad(player);
        }
    }

