package com.example.gaishnik;

import org.springframework.stereotype.Service;

@Service
public class SequentialNumberGenerator extends NumberGenerator {
    private int currentNumber = 0;
    private int letterIndex1 = 0;
    private int letterIndex2 = 0;
    private int letterIndex3 = 0;

    @Override
    public String generate() {
        try {
            if (getLastGeneratedNumber() != null) {
                int[] parsed = parseNumber(getLastGeneratedNumber());
                currentNumber = parsed[0];
                letterIndex1 = parsed[1];
                letterIndex2 = parsed[2];
                letterIndex3 = parsed[3];
                increment();
            }

            String number;
            do {
                number = formatNumber(currentNumber, letterIndex1, letterIndex2, letterIndex3);
                increment();
            } while (generatedNumbers.contains(number));

            generatedNumbers.add(number);
            setLastGeneratedNumber(number);
            return number;
        } catch (Exception e) {
            return "Ошибка генерации следующего числа: " + e.getMessage();
        }
    }

    private void increment() {
        currentNumber++;
        if (currentNumber > 999) {
            currentNumber = 0;
            letterIndex3++;
            if (letterIndex3 >= LETTERS.length()) {
                letterIndex3 = 0;
                letterIndex2++;
                if (letterIndex2 >= LETTERS.length()) {
                    letterIndex2 = 0;
                    letterIndex1++;
                    if (letterIndex1 >= LETTERS.length()) {
                        letterIndex1 = 0;
                    }
                }
            }
        }
    }

    private int[] parseNumber(String number) {
        int num = Integer.parseInt(number.substring(1, 4));
        int l1 = LETTERS.indexOf(number.charAt(0));
        int l2 = LETTERS.indexOf(number.charAt(4));
        int l3 = LETTERS.indexOf(number.charAt(5));
        return new int[]{num, l1, l2, l3};
    }
}