package com.example.textanalyzer.interfaces;

import com.example.textanalyzer.models.AnalyseKeyword;
import com.example.textanalyzer.models.LetterFrequency;

import java.util.List;

/**
 * An interface representing a service for generating letter frequencies from a given text.
 */
public interface TextAnalysisInterface {
    /**
     * Analyzes the provided text and generates letter frequencies, excluding or including specific letters.
     * <p>
     * Example vowels chars {a, e, i, o, u };
     *
     * @param text    the input text to be analyzed
     * @param letters an characters representing letters to be included/excluded from analysis.
     *                this make the algorithm more dynamic to count letter not the vowels only.
     * @param toBe    an string type(include/exclude) which make the one algorithm do both job of (vowels, consonants)
     * @return an object with text detail and List of frequency char objects of each letter in the text.
     */
    AnalyseKeyword letterFrequencyGenerator(String text, String letters, String toBe, String label);
}
