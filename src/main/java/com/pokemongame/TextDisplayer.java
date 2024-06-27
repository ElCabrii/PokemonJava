package com.pokemongame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextDisplayer {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void printWithDelay(String text) {
        int delay = 25;
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush(); // Ensure the character is printed immediately
            try {
                if (reader.ready()) { // Check if the Enter key has been pressed
                    reader.readLine(); // Clear the input buffer
                    System.out.println(text.substring(text.indexOf(c))); // Print the rest of the text
                    waitForEnterKey(); // Wait for the Enter key to be pressed again
                    return;
                }
                Thread.sleep(delay);
            } catch (InterruptedException | IOException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted, Failed to complete operation");
            }
        }

        System.out.println();
    }

    public static void waitForEnterKey() {
        try {
            while (!reader.ready()) {
                // Waiting for the Enter key to be pressed
                Thread.sleep(100); // Sleep to reduce CPU usage
            }
            reader.readLine(); // Clear the input buffer
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void clearConsole() {
        // Clear the console using ANSI escape code
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String readStoryFile(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}