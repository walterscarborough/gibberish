package com.walter;

import java.util.Scanner;

/**
 * Created by walter on 15/06/09.
 */
public class UserIOHandler {
    public String collectUserInput() {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        //System.out.println("input was " + userInput);

        return userInput;
    }

    public void displayInputPrompt() {

        String userInputGreeting = "Welcome to the Gibberish Dictionary!"
                + "\n"
                + "\n"
                + "Please enter the word that you would like translated."
                + "\n"
                + "e.g. hello"
                + "\n"
                ;

        System.out.println(userInputGreeting);

        String userInput = this.collectUserInput();

        String languageInputGreeting = "Great, thanks. Which language would you like to use?"
                + "\n"
                + "e.g. Japanese"
                + "\n"
                ;

        System.out.println(languageInputGreeting);

        String languageInput = this.collectUserInput();

        LanguageHandler languageHandler = new LanguageHandler();
        String translatedWord = languageHandler.lookupInputWord(userInput, languageInput);

        this.displayOutput(translatedWord);
    }

    public void displayOutput(String output) {

        String outputMessage = "Your translation is: '" + output + "'."
            + "\n"
            + "Thanks!"
            ;

        System.out.println(outputMessage);
    }
}
