package com.example.gaishnik;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class SequentialNumberGeneratorTest {

    private SequentialNumberGenerator sequentialNumberGenerator;

    @BeforeEach
    public void setUp() {
        sequentialNumberGenerator = new SequentialNumberGenerator();
    }

    @Test
    public void testSequentialNumbers() {
        sequentialNumberGenerator.setLastGeneratedNumber("С399ВА 116 RUS");
        String nextNumber = sequentialNumberGenerator.generate();
        assertEquals("С400ВА 116 RUS", nextNumber);
    }
    @Test
    public void testSequentialLetters() {
        sequentialNumberGenerator.setLastGeneratedNumber("С999ВА 116 RUS");
        String nextNumber = sequentialNumberGenerator.generate();
        assertEquals("С000ВЕ 116 RUS", nextNumber);
    }
}