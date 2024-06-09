package test.Chapters;

import test.Game;
import test.Pokemon.Status;
import test.TextDisplayer;
import test.Trainer;

public class Home {
        public static Trainer home(Trainer player) {
            String name = player.getName();
            String[] textToDisplay =
                    {"You go back to your house. \n" +
                            "Your mom is waiting for you. \n" +
                            "Mom: Hi honey, how was your day ? \n" +
                            "Trainer.getName: It was great mom, I chose my first Pokemon ! \n" +
                            "Now I am going to beging my travel! \n" +
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
                            name +"You see, i'm already better! \n"+
                            "Bye, see you when you will \n" +
                            "you start to walk through the village,"+
                            "When you pass, everyone greets you and wishes you good luck on your trip.\n"+
                            "You start to feel a bit strange, adrenalin of becoming an adult and travel alone circulate your veins.\n"+
                            "it's the beginning of your adrventure !!! "
                    };

            TextDisplayer.displayParagraph(textToDisplay[0]);
            Trainer bedrock = new Trainer("Bedrock");
            bedrock.addPokemonToTeam(Game.getPokemon("Squirtle", Status.TAMED));
            player.fight(bedrock);
            TextDisplayer.displayParagraph(textToDisplay[1]);

            return FirstRoad.firstRoad(player, name);
        }
    }

