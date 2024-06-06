package com.pokemongame;

import java.io.IOException;

public class TextDisplayer {
    public static final int DELAY_IN_MILLIS = 60;
    private static volatile boolean accelerate = false; // Flag to control acceleration

    public static void displayTextCharacterByCharacter(String textToDisplay) {
        accelerate = false; // Reset the acceleration flag
        Thread displayThread = new Thread(() -> {
            for (int i = 0; i < textToDisplay.length(); i++) {
                System.out.print(textToDisplay.charAt(i)); // Display a character

                try {
                    if (!accelerate) {
                        Thread.sleep(DELAY_IN_MILLIS); // Wait for the specified delay
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread inputThread = new Thread(() -> {
            try {
                while (displayThread.isAlive() && System.in.read() != '\n') {
                    // Waiting for the Enter key to be pressed
                }
                accelerate = true; // Set the flag to true to accelerate
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        displayThread.start();
        inputThread.start();

        try {
            displayThread.join(); // Wait for the display thread to finish
            inputThread.join(); // Wait for the input thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForEnterKey() {
        try {
            while (System.in.read() != '\n') {
                // Waiting for the Enter key to be pressed
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearConsole() {
        // Clear the console using ANSI escape code
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayParagraph(String textToDisplay) {
        displayTextCharacterByCharacter(textToDisplay);
        waitForEnterKey();
        clearConsole();
    }
    /*String text;
    int i =0;

    Timer timer = new Timer(80, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){

            char character[] = text.toCharArray();
            int arrayNumber = character.length;

            String s = String.valueOf(character[i]);

            textArea.append(s);

            i++;

            if(i == arrayNumber){
                i = 0;
                timer.stop();
            }
        }
    });*/
}