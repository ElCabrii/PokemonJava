package com.pokemongame.Chapters;

import com.pokemongame.TextDisplayer;
import com.pokemongame.Trainer;


public class FirstRoad {
    public static Trainer firstRoad(Trainer player){
            String[]textToDisplay=
                    { "You reach the first road outside the village. \n",

                    };


        TextDisplayer.printWithDelay(textToDisplay[0]);
        player.choosePath();




        return player;
    }
}

