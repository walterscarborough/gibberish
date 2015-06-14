package com.walter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by walter on 15/06/09.
 */
public class LanguageHandler {

    List<HashMap<String, String>> unknownWordLog = new ArrayList<HashMap<String, String>>();
    List<HashMap<String, String>> lookupActionLog = new ArrayList<HashMap<String, String>>();

    public LanguageHandler() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            this.unknownWordLog = mapper.readValue(new File("unknownWordLog.json"), new TypeReference<List<HashMap<String,String>>>() {});
            this.lookupActionLog = mapper.readValue(new File("lookupActionLog.json"), new TypeReference<List<HashMap<String,String>>>() {});
        }
        catch (IOException e) {
            // No op
            //System.out.println("serialization ex is: " + e);
        }
    }

    public String lookupInputWord(String inputWord, String targetLanguage) {

        LanguageBank languageBank = new LanguageBank();

        if (targetLanguage.equals("Japanese") && languageBank.languageStorage.get(targetLanguage).containsKey(inputWord)) {

            // Default lookup logging
            this.logLookupAction(inputWord, targetLanguage);

            String translatedWord = languageBank.languageStorage.get(targetLanguage).get(inputWord);

            return translatedWord;
        }
        else {

            // Unknown lookup logging
            this.logUnknownWord(inputWord, targetLanguage);
        }

        return "";
    }

    public void logUnknownWord(String inputWord, String targetLanguage) {

        try {
            HashMap<String, String> lookup = new HashMap<>();
            lookup.put("word", inputWord);
            lookup.put("targetLanguage", targetLanguage);
            this.unknownWordLog.add(lookup);
        }
        catch (Exception e) {
            // No op
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("unknownWordLog.json"), this.unknownWordLog);
        } catch (IOException e) {
            // No op
        }
    }

    public void logLookupAction(String inputWord, String targetLanguage) {

        try {
            HashMap<String, String> lookup = new HashMap<>();
            lookup.put("word", inputWord);
            lookup.put("targetLanguage", targetLanguage);
            this.lookupActionLog.add(lookup);
        }
        catch (Exception e) {
            // No op
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("lookupActionLog.json"), this.lookupActionLog);
        } catch (IOException e) {
            System.out.println("logLookup exception: " + e);
            // No op
        }
    }
}
