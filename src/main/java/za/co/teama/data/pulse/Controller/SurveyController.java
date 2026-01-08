package za.co.teama.data.pulse.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.teama.data.pulse.Service.SurveyService;


//Gets all surveys
@RestController
@RequestMapping("/api/survey")
public class SurveyController {
    private final SurveyService surveyService = null;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
}


