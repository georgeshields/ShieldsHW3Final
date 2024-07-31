package com.example.surveyapp.controller;

import com.example.surveyapp.exception.ResourceNotFoundException;
import com.example.surveyapp.model.Survey;
import com.example.surveyapp.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }

    @PutMapping("/{id}")
    public Survey updateSurvey(@PathVariable Long id, @RequestBody Survey surveyDetails) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));
        survey.setName(surveyDetails.getName());
        survey.setEmail(surveyDetails.getEmail());
        survey.setFeedback(surveyDetails.getFeedback());
        survey.setRating(surveyDetails.getRating());
        survey.setUpdatedAt(surveyDetails.getUpdatedAt());
        return surveyRepository.save(survey);
    }

    @DeleteMapping("/{id}")
    public void deleteSurvey(@PathVariable Long id) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));
        surveyRepository.delete(survey);
    }
}
