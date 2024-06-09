package test.Chapters;

import test.City;
import test.TextDisplayer;
import test.Trainer;

public class FirstRoad {
    public static Trainer firstRoad(Trainer player, String cityName){
        String[] textToDisplay = { "You reach the first road outside the village. \n" };

        TextDisplayer.displayParagraph(textToDisplay[0]);
        City city = new City(cityName);
        player.path(player, city);

        return player;
    }
}