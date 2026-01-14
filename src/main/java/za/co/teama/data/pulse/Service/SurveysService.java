package za.co.teama.data.pulse.Service;

import Dto.ChoiceDto;
import Dto.CreatorDto;
import Dto.QuestionDto;
import Dto.SurveyDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import za.co.teama.data.pulse.Models.Response;
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
        public SurveyDto addSurvey(Survey survey) {
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
                survey.getQuestions()
                        .stream()
                        .map(question -> new QuestionDto(
                                question.getId(),
                                question.getText(),
                                question.getChoiceOptions()
                                        .stream()
                                        .map(ChoiceDto::new)
                                        .toList()
                        ))
                        .toList(),
                survey.getCreatedAt(),
                survey.getResponses()
                        .stream()
                        .map(response -> response.getId().longValue())
                        .collect(Collectors.toList())
        );
    }
}
