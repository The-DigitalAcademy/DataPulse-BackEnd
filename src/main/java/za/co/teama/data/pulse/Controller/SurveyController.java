package za.co.teama.data.pulse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.teama.data.pulse.Models.Survey;
import za.co.teama.data.pulse.Service.SurveysService;


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
    public Object getAllSurveys() { return surveysService.getSurveys(); }

    @GetMapping("/{id}")
    public Object getSurveyById(@PathVariable Long id) { return surveysService.getSurveyById(id); }

    @PostMapping
    public Object addSurvey(@RequestBody Survey survey) {
        return surveysService.addSurvey(survey);
    }

    @DeleteMapping("/{id}")
    public Object deleteSurvey(@PathVariable Long id) { return surveysService.deleteSurvey(id); }

}


