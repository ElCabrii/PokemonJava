package Story.Chap1;
//the begining of the story
public class start {
    public static void start(String[] args) {
        String textToDisplay =
                "Welcome in a new world \n" +
                "A world full of mysterious creature called : Pokemon \n" +
                "You are \n" +

        int delayInMillis = 100; // Délai entre chaque caractère (en millisecondes)

        displayTextCharacterByCharacter(textToDisplay, delayInMillis);
    }

    public static void displayTextCharacterByCharacter(String textToDisplay, int delayInMillis) {
        for (int i = 0; i < textToDisplay.length(); i++) {
            System.out.print(textToDisplay.charAt(i)); // Afficher un caractère

            try {
                Thread.sleep(delayInMillis); // Attendre le délai spécifié
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

