package com.example.textanalyzer.models;

/**
 * A record class representing the frequency of a letter in a text.
 * It encapsulates information about the letter and its frequency.
 *
 * Example:
 * input {id: 1, letter: 'a', frequency: 4}
 * output {letter: 'a', frequency: 4}
 */
public record LetterFrequencyFormatter(char letter, int frequency) {
}
