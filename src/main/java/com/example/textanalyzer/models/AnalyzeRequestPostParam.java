package com.example.textanalyzer.models;


public class AnalyzeRequestPostParam {
    private final String text;
    private final String label;
    private final String letters;
    private final String toBe;

    public AnalyzeRequestPostParam(String text, String label, String letters, String toBe) {
        this.text = text;
        this.label = label;
        this.letters = letters;
        this.toBe = toBe;
    }

    public String getText() {
        return text;
    }

    public String getLabel() {
        return label;
    }

    public String getLetters() {
        return letters;
    }

    public String getToBe() {
        return toBe;
    }

    @Override
    public String toString() {
        return "AnalyzeRequestPostParam{" +
                "text='" + text + '\'' +
                ", label='" + label + '\'' +
                ", letters='" + letters + '\'' +
                ", toBe='" + toBe + '\'' +
                '}';
    }
}
