package com.walter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by walter on 15/06/09.
 */
public class LanguageBank {

    Map<String, HashMap<String, String>> languageStorage = new HashMap<String, HashMap<String, String>>();

    public LanguageBank() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            this.languageStorage = mapper.readValue(new File("languageStorage.json"), new TypeReference<HashMap<String, HashMap<String,String>>>() {});
        }
        catch (IOException e) {
            // No op
        }
    }

    public void addTranslation(String addTranslationSourceWord, String addTranslationTargetLanguage, String addTranslationTargetWord) {
        // put in this.languageStorage

        HashMap<String, String> targetLanguageHash = this.languageStorage.get(addTranslationTargetLanguage);

        if (targetLanguageHash.isEmpty()) {
            targetLanguageHash = new HashMap<String, String>();
        }

        targetLanguageHash.put(addTranslationSourceWord, addTranslationTargetWord);

        this.languageStorage.put(addTranslationTargetLanguage, targetLanguageHash);

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("languageStorage.json"), this.languageStorage);
        } catch (IOException e) {
            // No op
        }
    }

    public void removeTranslation(String removeTranslationSourceWord, String removeTranslationTargetLanguage) {
        HashMap<String, String> targetLanguageHash = this.languageStorage.get(removeTranslationTargetLanguage);

        if (targetLanguageHash.isEmpty()) {
            targetLanguageHash = new HashMap<String, String>();
        }

        targetLanguageHash.remove(removeTranslationSourceWord);

        this.languageStorage.put(removeTranslationTargetLanguage, targetLanguageHash);

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("languageStorage.json"), this.languageStorage);
        } catch (IOException e) {
            // No op
        }
    }
}
