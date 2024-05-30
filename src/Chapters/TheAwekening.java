package src.Chapters;


import src.Player;
import src.TextDisplayer;


    public class TheAwekening {
        public static void wakeUp(String[] args) {
            String textToDisplay =
                    "You start to wake up ...\n" +
                    "You remerbering the last night \n" +
                    "The Party Was amazing for your 18 years old \n" +
                    "But you drink a little bit too much \n" +
                    "You look around you and you see a Pokemon \n" +
                    "A familiar voice is talking your name \n" +
                    Player.getName() + " ! " +
                    "Professor Java: I'm glad you wake up ! \n" +
                    "You tried to beat your dad in pokeshot battle last night \n" +
                    "But you lose and you fall asleep \n" +
                    "He carry you in my laboratory, he want you to choose your first Pokemon asap!\n" +
                    "He told me that you will be a great Pokemon Trainer , and he dont want to pay food for you now you are major...\n" +
                    "You need to choose your first Pokemon now !\n" +
                    "Here are the 3 Pokemon you can choose from : \n" +
                    "1. Bulbasaur\n" +
                    "2. Charmander\n" +
                    "3. Squirtle\n" +
                    "Choose wisely !";
            //TheChoice.getPokemon(args);
            TextDisplayer.displayParagraph(textToDisplay);

            TheChoice.theChoice(args);

        }
    }


}

