package com.example.textanalyzer.models;

import java.util.List;

public class AnalyseKeyword {
    private int keyIndex;
    private String keyword;
    private int totalFrequency;

    List<LetterFrequencyFormatter> letters;

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getTotalFrequency() {
        return totalFrequency;
    }

    public void setTotalFrequency(int totalFrequency) {
        this.totalFrequency = totalFrequency;
    }

    public List<LetterFrequencyFormatter> getLetters() {
        return letters;
    }

    public void setLetters(List<LetterFrequencyFormatter> letters) {
        this.letters = letters;
    }

    @Override
    public String toString() {
        return "AnalyseKeyword{" +
                "keyIndex=" + keyIndex +
                ", keyword='" + keyword + '\'' +
                ", totalFrequency=" + totalFrequency +
                ", letters=" + letters +
                '}';
    }
}
