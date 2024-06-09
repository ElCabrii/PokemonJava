package com.pokemongame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;

public class TextDisplayer {
    /*public static final int DELAY_IN_MILLIS = 60;
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
    }*/
    public static void printWithDelay(String text) {
        int delay = 25;
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush(); // Ensure the character is printed immediately
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted, Failed to complete operation");
            }
        }
        System.out.println();
    }
}