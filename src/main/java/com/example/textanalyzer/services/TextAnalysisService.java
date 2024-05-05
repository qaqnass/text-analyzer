package com.example.textanalyzer.services;


import com.example.textanalyzer.interfaces.TextAnalysisInterface;
import com.example.textanalyzer.models.AnalyseKeyword;
import com.example.textanalyzer.models.LetterFrequencyFormatter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

/**
 * A service class implementing the TextAnalysisInterface for analyzing text.
 * It provides functionality to analyze text and generate letter frequencies.
 */
@Service
public class TextAnalysisService implements TextAnalysisInterface {

    @Override
    public AnalyseKeyword letterFrequencyGenerator(String text, String letters, String toBe, String label) {
        AnalyseKeyword keyword = new AnalyseKeyword();
        keyword.setKeyword(label);

        keyword.setLetters(letterFrequencyHandler(text, letters, toBe));
        return keyword;
    }

    private List<LetterFrequencyFormatter> letterFrequencyHandler(String text, String letters, String toBe) {
        text = text.toLowerCase();
        letters = letters.toLowerCase();

        Map<Character, Integer> includedCharsFrequency = new HashMap<>();
        Map<Character, Integer> excludeCharsFrequency = new HashMap<>();

        for (char letter : letters.toCharArray()) {
            if (!includedCharsFrequency.containsKey(letter)) {
                includedCharsFrequency.put(letter, 0);
            }
        }

        // Compile the pattern reg.
        Pattern p = Pattern.compile("^[a-z ]+$");

        for (char letter : text.toCharArray()) {
            // converting char to string to check if allowed to be in the object or not[a-z ]
            if (p.matcher(String.valueOf(letter)).matches()) {
                if (includedCharsFrequency.containsKey(letter) && toBe.equals("include")) {
                    includedCharsFrequency.put(letter, includedCharsFrequency.get(letter) + 1);
                }
                if (!includedCharsFrequency.containsKey(letter) && toBe.equals("exclude")) {
                    excludeCharsFrequency.put(
                            letter,
                            excludeCharsFrequency.containsKey(letter) ? excludeCharsFrequency.get(letter) + 1 : 1);
                }
            }
        }

        return letterFrequencyConverterHandler(toBe.equals("include") ? includedCharsFrequency : excludeCharsFrequency);
    }

    private List<LetterFrequencyFormatter> letterFrequencyConverterHandler(Map<Character, Integer> letterFrequency) {
        List<LetterFrequencyFormatter> newLetterFrequency = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : letterFrequency.entrySet()) {
            // to exclude id, as we don't need id for now. we just need object like [{letter: "a", frequency: 2}].
            newLetterFrequency.add(new LetterFrequencyFormatter(entry.getKey(), entry.getValue()));
        }

        return newLetterFrequency;
    }
}