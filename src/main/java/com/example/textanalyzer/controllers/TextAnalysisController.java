package com.example.textanalyzer.controllers;

import com.example.textanalyzer.exception.ApiExceptionHandler;
import com.example.textanalyzer.models.AnalyseKeyword;
import com.example.textanalyzer.models.AnalyzeRequestPostParam;
import com.example.textanalyzer.services.TextAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;

/**
 * Controller class for handling text analysis related operations.
 * This controller is responsible for exposing RESTful endpoints for text analysis tasks.
 * All endpoints in this controller are part of version 1(/textanalysis/v1) of the Text Analysis API.
 */

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/textanalyzer/v1/api")
public class TextAnalysisController {

    private final TextAnalysisService textAnalysisService;

    @Autowired
    public TextAnalysisController(TextAnalysisService textAnalysisService) {
        this.textAnalysisService = textAnalysisService;
    }

    @PostMapping("/generate")
    public AnalyseKeyword analyzeText(@RequestBody AnalyzeRequestPostParam param) {
        if (!param.getToBe().equals("include")  && !param.getToBe().equals("exclude")) {
            throw new ApiExceptionHandler("Sorry we don't support this type");
        }

        AnalyseKeyword keyword = textAnalysisService.letterFrequencyGenerator(param.getText(), param.getLetters(), param.getToBe(), param.getLabel());
        if (keyword == null) {
            throw new ApiExceptionHandler("we have a problem with analyze your text please try again later");
        }

        return keyword;
    }

}