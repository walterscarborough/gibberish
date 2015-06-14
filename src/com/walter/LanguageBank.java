package com.walter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by walter on 15/06/09.
 */
public class LanguageBank {

    Map<String,String> japaneseLanguageBank = new HashMap<>();

    public LanguageBank() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            this.japaneseLanguageBank = mapper.readValue(new File("japaneseLanguageBank.json"), Map.class);
        }
        catch (IOException e) {
            // No op
        }
    }

    public void addTranslation() {
        // put in this.japaneseLanguageBank
        // mapper.writeValue(new File("japaneseLanguageBank.json"), japaneseLanguageBank);
    }

    public void removeTranslation() {

    }
}
