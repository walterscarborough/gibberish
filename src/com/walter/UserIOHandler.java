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

        String userActionGreeting = "Welcome to the Gibberish Dictionary!"
                + "\n"
                + "\n"
                + "What would you like to do?"
                + "\n"
                + "1 - Lookup Word"
                + "\n"
                + "2 - Add Translation"
                + "\n"
                + "3 - Remove Translation"
                + "\n"
                ;


        System.out.println(userActionGreeting);

        String userAction = this.collectUserInput();

        switch (userAction) {
            case "1":

                String userInputGreeting = "\n"
                    + "Please enter the word that you would like translated."
                    + "\n"
                    + "e.g. hello"
                    + "\n"
                    ;

                System.out.println(userInputGreeting);

                String userInput = this.collectUserInput();

                String languageInputGreeting = "\n"
                        + "Great, thanks. Which language would you like to use?"
                        + "\n"
                        + "e.g. Japanese"
                        + "\n"
                        ;

                System.out.println(languageInputGreeting);

                String languageInput = this.collectUserInput();

                LanguageHandler languageHandler = new LanguageHandler();
                String translatedWord = languageHandler.lookupInputWord(userInput, languageInput);

                String outputMessage = "\n"
                        + "Your translation is: '" + translatedWord + "'."
                        + "\n"
                        + "Thanks!"
                        ;

                this.displayOutput(outputMessage);
                break;

            case "2":

                String addTranslationGreeting = "\n"
                        + "Please enter the word that you would like to translate."
                        + "\n"
                        + "e.g. hello"
                        + "\n"
                        ;

                System.out.println(addTranslationGreeting);

                String addTranslationSourceWord = this.collectUserInput();

                String addTranslationLanguageGreeting = "\n"
                        + "Great, thanks. Which language would you like to translate it into?"
                        + "\n"
                        + "e.g. Japanese"
                        + "\n"
                        ;

                System.out.println(addTranslationLanguageGreeting);

                String addTranslationTargetLanguage = this.collectUserInput();

                String addTranslationTargetWordGreeting = "\n"
                        + "What is the translation in the target language?"
                        + "\n"
                        ;

                System.out.println(addTranslationTargetWordGreeting);

                String addTranslationTargetWord= this.collectUserInput();

                LanguageBank addTranslationLanguageBank = new LanguageBank();
                addTranslationLanguageBank.addTranslation(addTranslationSourceWord, addTranslationTargetLanguage, addTranslationTargetWord);

                String addTranslationOutputMessage = "\n"
                        + "Thanks for adding that!"
                        ;

                this.displayOutput(addTranslationOutputMessage);

                break;

            case "3":

                String removeTranslationGreeting = "\n"
                        + "Please enter the source language word that you would like to remove."
                        + "\n"
                        + "e.g. hello"
                        + "\n"
                        ;

                System.out.println(removeTranslationGreeting);

                String removeTranslationSourceWord = this.collectUserInput();

                String removeTranslationLanguageGreeting = "\n"
                        + "Great, thanks. Which language would you like to remove it from?"
                        + "\n"
                        + "e.g. Japanese"
                        + "\n"
                        ;

                System.out.println(removeTranslationLanguageGreeting);

                String removeTranslationTargetLanguage = this.collectUserInput();

                LanguageBank removeTranslationLanguageBank = new LanguageBank();
                removeTranslationLanguageBank.removeTranslation(removeTranslationSourceWord, removeTranslationTargetLanguage);

                String removeTranslationOutputMessage = "\n"
                        + "Removal complete. Thanks!"
                        ;

                this.displayOutput(removeTranslationOutputMessage);


                break;
        }
    }

    public void displayOutput(String outputMessage) {
        System.out.println(outputMessage);
    }
}
