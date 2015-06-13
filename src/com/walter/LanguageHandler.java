package com.walter;

import java.io.*;

/**
 * Created by walter on 15/06/09.
 */
public class LanguageHandler {
    public String lookupInputWord(String inputWord, String targetLanguage) {

        LanguageBank languageBank = new LanguageBank();

        if (targetLanguage.equals("Japanese") && languageBank.japaneseLanguageBank.containsKey(inputWord) == true) {

            // Default lookup logging
            this.logLookupAction(inputWord, targetLanguage);

            String translatedWord = languageBank.japaneseLanguageBank.get(inputWord);

            return translatedWord;
        }
        else {

            // Unknown lookup logging
            this.logUnknownWord(inputWord, targetLanguage);
        }

        return "";
    }

    public void logUnknownWord(String inputWord, String targetLanguage) {

        try (
            PrintWriter out = new PrintWriter(
                new BufferedWriter(
                    new FileWriter("unknownWordLog.txt", true)
                )
            );
        ) {
            out.println("inputWord: " + inputWord + "; targetLanguage: " + targetLanguage);
        }
        catch (IOException e) {
            // No op
        }
    }

    public void logLookupAction(String inputWord, String targetLanguage) {

        try (
            PrintWriter out = new PrintWriter(
                new BufferedWriter(
                    new FileWriter("lookupActionLog.txt", true)
                )
            );
        ) {
            out.println("inputWord: " + inputWord + "; targetLanguage: " + targetLanguage);
        }
        catch (IOException e) {
            // No op
        }
    }
}
