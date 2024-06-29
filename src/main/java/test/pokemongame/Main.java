package test.pokemongame;

import org.json.simple.parser.ParseException;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Game.readFromJson();
        Trainer player = Game.start();
    }
}
