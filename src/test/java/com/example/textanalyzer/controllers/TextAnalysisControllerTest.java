package com.example.textanalyzer.controllers;

import com.example.textanalyzer.models.AnalyseKeyword;
import com.example.textanalyzer.models.AnalyzeRequestPostParam;
import com.example.textanalyzer.models.LetterFrequencyFormatter;
import com.example.textanalyzer.services.TextAnalysisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
public class TextAnalysisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TextAnalysisService stringService;

    @Test
    public void analyzeText() throws Exception {
        AnalyzeRequestPostParam params = new AnalyzeRequestPostParam("abcd", "consonants", "aeiou", "include");
        AnalyseKeyword keyword = createSampleKeyword(params);
        when(stringService.letterFrequencyGenerator(params.getText(), params.getLetters(), params.getToBe(), params.getLabel())).thenReturn(keyword);

        List<LetterFrequencyFormatter> letters;
        mockMvc.perform(MockMvcRequestBuilders.post("/textanalyzer/v1/api/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(params)))
                // Assert response status code is CREATED (200)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.keyIndex").value(0))
                .andExpect(jsonPath("$.totalFrequency").value(0))
                .andExpect(jsonPath("$.keyword").value(params.getLabel()))
                .andExpect(jsonPath("$.letters").isArray())
                .andExpect(jsonPath("$.letters.length()").value(3))

                .andExpect(jsonPath("$.letters[0].letter").value("b"))
                .andExpect(jsonPath("$.letters[0].frequency").value(1))
                .andExpect(jsonPath("$.letters[1].letter").value("c"))
                .andExpect(jsonPath("$.letters[1].frequency").value(1))
                .andExpect(jsonPath("$.letters[2].letter").value("d"))
                .andExpect(jsonPath("$.letters[2].frequency").value(1));
    }

    private AnalyseKeyword createSampleKeyword(AnalyzeRequestPostParam params) {
        AnalyseKeyword keyword = new AnalyseKeyword();
        keyword.setKeyword(params.getLabel());

        List<LetterFrequencyFormatter> letters = new ArrayList<>();
        letters.add(new LetterFrequencyFormatter('b', 1));
        letters.add(new LetterFrequencyFormatter('c', 1));
        letters.add(new LetterFrequencyFormatter('d', 1));

        keyword.setLetters(letters);
        return keyword;
    }
}
