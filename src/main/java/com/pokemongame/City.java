package com.pokemongame;

public class City {
    private final String name;
    private final Places[] places;
    public City(String name) {
        this.name = name;
        this.places = new Places[]{Places.ARENA, Places.NURSERY, Places.SHOP, Places.NORTHERN_ROAD, Places.SOUTHERN_ROAD, Places.EASTERN_ROAD, Places.WESTERN_ROAD};
    }
    public String getName() {
        return name;
    }
    public Places[] getPlaces() {
        return places;
    }
}
