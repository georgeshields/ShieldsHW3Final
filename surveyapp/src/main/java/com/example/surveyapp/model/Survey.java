package com.example.surveyapp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String telephoneNumber;
    private String email;
    private LocalDate dateOfSurvey;

    private LikedMost likedMost;
    private InterestSource interestSource;
    private RecommendationLikelihood recommendationLikelihood;

    // Enums for the fixed set of options
    public enum LikedMost {
        STUDENTS, LOCATION, CAMPUS, ATMOSPHERE, DORM_ROOMS, SPORTS
    }

    public enum InterestSource {
        FRIENDS, TELEVISION, INTERNET, OTHER
    }

    public enum RecommendationLikelihood {
        VERY_LIKELY, LIKELY, UNLIKELY
    }

    // Constructors
    public Survey() {}

    public Survey(String firstName, String lastName, String streetAddress, String city, String state, String zip, String telephoneNumber, String email, LocalDate dateOfSurvey, LikedMost likedMost, InterestSource interestSource, RecommendationLikelihood recommendationLikelihood) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.dateOfSurvey = dateOfSurvey;
        this.likedMost = likedMost;
        this.interestSource = interestSource;
        this.recommendationLikelihood = recommendationLikelihood;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(LocalDate dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public LikedMost getLikedMost() {
        return likedMost;
    }

    public void setLikedMost(LikedMost likedMost) {
        this.likedMost = likedMost;
    }

    public InterestSource getInterestSource() {
        return interestSource;
    }

    public void setInterestSource(InterestSource interestSource) {
        this.interestSource = interestSource;
    }

    public RecommendationLikelihood getRecommendationLikelihood() {
        return recommendationLikelihood;
    }

    public void setRecommendationLikelihood(RecommendationLikelihood recommendationLikelihood) {
        this.recommendationLikelihood = recommendationLikelihood;
    }
}
