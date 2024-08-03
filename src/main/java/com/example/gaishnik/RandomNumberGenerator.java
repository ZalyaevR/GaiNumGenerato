package com.example.gaishnik;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RandomNumberGenerator extends NumberGenerator {
    private final Random random = new Random();

    @Override
    public String generate() {
        try {
            String number;
            do {
                number = generateRandomNumber();
            } while (generatedNumbers.contains(number));
            generatedNumbers.add(number);
            setLastGeneratedNumber(number);
            return number;
        } catch (Exception e) {
            return "Ошибка генерации случайного числа: " + e.getMessage();
        }
    }

    private String generateRandomNumber() {
        return formatNumber(randomDigits(), randomLetter(),randomLetter(),randomLetter());
    }

    private int randomLetter() {
        return random.nextInt(LETTERS.length());
    }

    private int randomDigits() {
        return random.nextInt(1000);
    }
}