package com.example.gaishnik;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.gaishnik.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    public void testGenerate() {
        String number = randomNumberGenerator.generate();
        assertNotNull(number);
        assertTrue(number.matches("^[АЕТОРНУКХСВМ]{1}[0-9]{3}[АЕТОРНУКХСВМ]{2} 116 RUS$"));
    }

    @Test
    public void testUniqueNumbers() {
        Set<String> generatedNumbers = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            String number = randomNumberGenerator.generate();
            assertTrue(generatedNumbers.add(number));
        }
    }
}