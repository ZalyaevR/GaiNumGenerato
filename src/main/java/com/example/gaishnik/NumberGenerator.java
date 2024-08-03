package com.example.gaishnik;

import java.util.HashSet;
import java.util.Set;

public abstract class NumberGenerator {
    protected static final String LETTERS = "АЕТОРНУКХСВМ";
    protected static final String REGION = " 116 RUS";
    protected final Set<String> generatedNumbers = new HashSet<>();
    private static volatile String lastGeneratedNumber = null;

    public abstract String generate();

    protected static synchronized String getLastGeneratedNumber() {
        return lastGeneratedNumber;
    }

    protected static synchronized void setLastGeneratedNumber(String number) {
        lastGeneratedNumber = number;
    }

    protected String formatNumber(int number, int l1, int l2, int l3) {
        StringBuilder sb = new StringBuilder();
        sb.append(LETTERS.charAt(l1))
                .append(String.format("%03d", number))
                .append(LETTERS.charAt(l2))
                .append(LETTERS.charAt(l3))
                .append(REGION);
        return sb.toString();
    }
}