package za.co.teama.data.pulse.Controller;

import Dto.SurveyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.teama.data.pulse.Models.Survey;
import za.co.teama.data.pulse.Service.SurveysService;

import java.util.List;
import java.util.Optional;


//Gets all surveys
@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private final SurveysService surveysService;

    public SurveyController(SurveysService surveyService) {
        this.surveysService = surveyService;
    }

    @GetMapping
    public List<SurveyDto> getAllSurveys() { return surveysService.getSurveys(); }

    @GetMapping("/{id}")
    public Optional<SurveyDto> getSurveyById(@PathVariable Integer id) {
        return surveysService.getSurveyById(id); }

    @PostMapping
    public SurveyDto addSurvey(@RequestBody Survey survey) {
        return surveysService.addSurvey(survey);
    }

    @DeleteMapping("/{id}")
    public Optional<SurveyDto> deleteSurvey(@PathVariable Integer id) { return surveysService.deleteSurvey(id); }

}


