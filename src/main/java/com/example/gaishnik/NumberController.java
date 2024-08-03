package com.example.gaishnik;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {
    @Value("${app.name:Gai Number Generator API}")
    private String appName;
    private final RandomNumberGenerator randomNumberGenerator;
    private final SequentialNumberGenerator sequentialNumberGenerator;

    public NumberController(RandomNumberGenerator randomNumberGenerator, SequentialNumberGenerator sequentialNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.sequentialNumberGenerator = sequentialNumberGenerator;
    }

    @GetMapping("/random")
    public String getRandomNumber() {
        return randomNumberGenerator.generate();
    }

    @GetMapping("/next")
    public String getNextNumber() {
        return sequentialNumberGenerator.generate();
    }

    @GetMapping("/")
    public String getInfo() {
        return "<pre>" + appName + "\n\n" +
                "Доступные методы:\n" +
                "/random - Генерирует случайный рег.номер\n" +
                "/next - Последовательно выдает рег.номер от меньшего к большему\n</pre>";
    }
}