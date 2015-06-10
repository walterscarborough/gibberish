package com.walter;

import java.util.Scanner;

/**
 * Created by walter on 15/06/09.
 */
public class UserIOHandler {
    public String collectUserInput() {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        System.out.println("input was " + userInput);

        return userInput;
    }

    public void displayInputPrompt() {

        String greeting = "Welcome to the dictionary."
                        + " Please enter the word and language that you would like translated."
                        ;

        System.out.println(greeting);

        String userInput = collectUserInput();
    }

    public void displayOutput() {

    }
}
