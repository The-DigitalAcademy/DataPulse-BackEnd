package za.co.teama.data.pulse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.teama.data.pulse.Service.SurveysService;


//Gets all surveys
@RestController
@RequestMapping("/api/survey")
public class SurveyController {

    @Autowired
    private final SurveysService surveysService;

    public SurveyController(SurveysService surveyService) {
        this.surveysService = surveyService;
    }

    @GetMapping("/surveys")
    private Object getAllSurveys() {
       return surveysService.getSurveys();
    }
}


