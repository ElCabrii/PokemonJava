package test.pokemongame.Chapters;

import test.pokemongame.City;
import test.pokemongame.TextDisplayer;
import test.pokemongame.Trainer;


public class FirstRoad {
    public static Trainer firstRoad(Trainer player){
            String[]textToDisplay=
                    { "You reach the first road outside the village. \n",

                    };
        TextDisplayer.printWithDelay(textToDisplay[0]);
        player.choosePath(City.VIRIDIAN_CITY, City.PALLET_TOWN, City.PEWTER_CITY);
        return player;
    }
}

