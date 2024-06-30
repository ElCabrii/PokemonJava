package com.pokemongame.Chapters;

import com.pokemongame.City;
import com.pokemongame.TextDisplayer;
import com.pokemongame.Trainer;

public class Nextstep {
    public static Trainer nextStep(Trainer player) {
        TextDisplayer.readStoryFile("data/story1/Home1");
        player.choosePath(City.PEWTER_CITY, City.VIRIDIAN_CITY, City.CERULEAN_CITY);
        return player;
    }



}
