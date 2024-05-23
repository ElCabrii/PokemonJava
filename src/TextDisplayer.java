package src;

public class TextDisplayer {
    public static final int DELAY_IN_MILLIS = 60;

    public static void displayTextCharacterByCharacter(String textToDisplay) {
        for (int i = 0; i < textToDisplay.length(); i++) {
            System.out.print(textToDisplay.charAt(i)); // Display a character

            try {
                Thread.sleep(DELAY_IN_MILLIS); // Wait for the specified delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
