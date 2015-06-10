package com.walter;

/**
 * Created by walter on 15/06/09.
 */
public class LanguageHandler {
    public String lookupInputWord(String inputWord, String targetLanguage) {
        LanguageBank languageBank = new LanguageBank();

        if (languageBank.japaneseLanguageBank.containsKey(inputWord) == true) {
            String translatedWord = languageBank.japaneseLanguageBank.get(inputWord);

            return translatedWord;
        }

        return "";
    }

    public void logUnknownWord() {

    }

    public void logLookupAction() {

    }
}
