package com.pokemongame;

public enum City {
    PALLET_TOWN,
    VIRIDIAN_CITY,
    PEWTER_CITY,
    CERULEAN_CITY,
    VERMILION_CITY,
    LAVENDER_TOWN,
    CELADON_CITY,
    FUCHSIA_CITY,
    SAFFRON_CITY,
    CINNABAR_ISLAND,
    ;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enterCity(City previousCity, City city, City nextCity) {
    }

    public void enterCity(City city) {
    }
}