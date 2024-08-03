package com.example.gaishnik;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(NumberController.class)
public class NumberControllerTest {

    @Value("${app.name:Gai Number Generator API}")
    private String appName;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RandomNumberGenerator randomNumberGenerator;

    @MockBean
    private SequentialNumberGenerator sequentialNumberGenerator;

    @Test
    public void testGetRandomNumber() throws Exception {
        when(randomNumberGenerator.generate()).thenReturn("А001А 116 RUS");

        mockMvc.perform(MockMvcRequestBuilders.get("/random"))
                .andExpect(status().isOk())
                .andExpect(content().string("А001А 116 RUS"));
    }

    @Test
    public void testGetNextNumber() throws Exception {
        when(sequentialNumberGenerator.generate()).thenReturn("А001А 116 RUS");

        mockMvc.perform(MockMvcRequestBuilders.get("/next"))
                .andExpect(status().isOk())
                .andExpect(content().string("А001А 116 RUS"));
    }

    @Test
    public void testGetInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString(appName)));
    }
}