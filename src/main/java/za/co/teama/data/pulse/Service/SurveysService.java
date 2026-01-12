package za.co.teama.data.pulse.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import za.co.teama.data.pulse.Models.Survey;
import za.co.teama.data.pulse.Repository.SurveyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SurveysService {

        private final SurveyRepository surveyRepo;

        public SurveysService(SurveyRepository surveyRepo){ this.surveyRepo = surveyRepo; }

        // Get Service
        public List<Survey> getSurveys() {
            return surveyRepo.findAll();
        }

       // Get by ID
        public Optional<Survey> getSurveyById(Long id) {
            return surveyRepo.findById(id);
        }

       // Save survey
        public Survey addSurvey(Survey survey) {
            return surveyRepo.save(survey);

        }

      // Delete Survey
        public Survey deleteSurvey(Long id) {
            var survey = surveyRepo.findById(id);
            surveyRepo.deleteById(id);
            return null;
        }


}
