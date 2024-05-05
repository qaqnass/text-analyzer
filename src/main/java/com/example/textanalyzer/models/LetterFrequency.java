package com.example.textanalyzer.models;

public class LetterFrequency {
    private  long id;
    private char letter;

    private int frequency;

    public LetterFrequency(char letter, int frequency) {
        this.id = id;
        this.letter = letter;
        this.frequency = frequency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "LetterFrequency{" +
                "id=" + id +
                ", letter=" + letter +
                ", frequency=" + frequency +
                '}';
    }
}