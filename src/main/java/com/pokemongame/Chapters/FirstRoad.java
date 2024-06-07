package com.pokemongame.Chapters;
import com.pokemongame.Chapters.Home;
import com.pokemongame.TextDisplayer;
import com.pokemongame.Trainer;
import com.pokemongame.Game;

public class FirstRoad {
    public static Trainer firstRoad(Trainer player){
            String[]textToDisplay=
                    { "You reach the first road outside the village. \n",

                    };


        TextDisplayer.displayParagraph(textToDisplay[0]);
        player.path(player, "TAR");




        return player;
    }
}

