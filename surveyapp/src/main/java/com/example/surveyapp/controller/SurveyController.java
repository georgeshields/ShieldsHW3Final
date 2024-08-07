package com.example.surveyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.surveyapp.exception.ResourceNotFoundException;
import com.example.surveyapp.model.Survey;
import com.example.surveyapp.repository.SurveyRepository;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    // Get all surveys
    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // Create a new survey
    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }

    // Update an existing survey
    @PutMapping("/{id}")
    public Survey updateSurvey(@PathVariable Long id, @RequestBody Survey surveyDetails) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));

        // Updating the fields with the new survey details
        survey.setFirstName(surveyDetails.getFirstName());
        survey.setLastName(surveyDetails.getLastName());
        survey.setStreetAddress(surveyDetails.getStreetAddress());
        survey.setCity(surveyDetails.getCity());
        survey.setState(surveyDetails.getState());
        survey.setZip(surveyDetails.getZip());
        survey.setTelephoneNumber(surveyDetails.getTelephoneNumber());
        survey.setEmail(surveyDetails.getEmail());
        survey.setDateOfSurvey(surveyDetails.getDateOfSurvey());
        survey.setLikedMost(surveyDetails.getLikedMost());
        survey.setInterestSource(surveyDetails.getInterestSource());
        survey.setRecommendationLikelihood(surveyDetails.getRecommendationLikelihood());

        return surveyRepository.save(survey);
    }

    // Delete a survey
    @DeleteMapping("/{id}")
    public void deleteSurvey(@PathVariable Long id) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));
        surveyRepository.delete(survey);
    }
}
