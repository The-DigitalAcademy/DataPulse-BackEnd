package za.co.teama.data.pulse.Service;

import Dto.CreatorDto;
import Dto.SurveyDto;
import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Models.Choice;
import za.co.teama.data.pulse.Models.Question;
import za.co.teama.data.pulse.Models.Survey;
import za.co.teama.data.pulse.Repository.SurveyRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurveysService {

        private final SurveyRepository surveyRepo;

        public SurveysService(SurveyRepository surveyRepo){ this.surveyRepo = surveyRepo; }

        // Get Service
        public List<SurveyDto> getSurveys() {
            return surveyRepo.findAll()
                    .stream()
                    .map(this::convertToDto)  // convert each Survey to SurveyDto
                    .toList();
        }

       // Get by ID
        public Optional<SurveyDto> getSurveyById(Long id) {
            return surveyRepo.findById(id)
                  .map(this::convertToDto);
        }

       // Save survey
//        public SurveyDto addSurvey(Survey survey) {
//            Survey saved = surveyRepo.save(survey);
//            return convertToDto(saved);
//
//        }

    /**
     * Front end post survey with question dto filled, update method to also write Questions and Choice [relationships]
     * @param survey - posted with questions list filled.
     * @return created Survey
     */
           public SurveyDto addSurvey(Survey survey) {
               // bidirectional relationships before saving
               if (survey.getQuestions() != null) {
                   for (Question question : survey.getQuestions()) {
                       question.setSurvey(survey);
                       // set bidirectional relationship for choices
                       if (question.getChoiceOptions() != null) {
                           for (Choice choice : question.getChoiceOptions()) {
                               choice.setQuestion(question);
                           }
                       }
                   }
               }
           Survey saved = surveyRepo.save(survey);
           return convertToDto(saved);
       }

      // Delete Survey
        public Optional<SurveyDto> deleteSurvey(Long id) {
            return surveyRepo.findById(id)
                    .map(survey -> {
                        surveyRepo.deleteById(id);
                        return convertToDto(survey);
                    });
        }


    private SurveyDto convertToDto(Survey survey) {
        return new SurveyDto(
                survey.getId(),
                survey.getTitle(),
                survey.getDescription(),
                survey.isOpen(),
                new CreatorDto(survey.getCoordinator()),
                survey.getCreatedAt(),
                survey.getResponses()
                        .stream()
                        .map(response -> response.getId().longValue())
                        .collect(Collectors.toList())
        );
    }
}
