package za.co.teama.data.pulse.Service;

import Dto.AnswerDto;
import Dto.ResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Models.*;
import za.co.teama.data.pulse.Repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChoiceRepository choiceRepository;

    private final ResponseRepository responseRepo;

    public ResponseService(ResponseRepository responseRepo) { this.responseRepo = responseRepo; }

    //Get responses
    public List<Response> getResponses() {
        return responseRepo.findAll();
    }

    //Create Responses
//    @Transactional
    public Response addResponse(ResponseDto dto) {
        // Create new Response entity
        Response response = new Response();
        // 1. Fetch and set Survey
        Survey survey = surveyRepository.findById(dto.getSurveyId())
                .orElseThrow(() -> new RuntimeException("Survey not found with id: " + dto.getSurveyId()));
        response.setSurvey(survey);
        // 2. Fetch and set User (respondent)
        UUID uui = UUID.fromString(dto.getUserId());
        User respondent = userRepository.findById(uui)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));
        response.setRespondent(respondent);
        // 3. Create Answer entities
        List<Answer> answers = new ArrayList<>();
        for (AnswerDto answerDto : dto.getAnswers()) {
            Answer answer = new Answer();
            // Set response relationship
            answer.setResponse(response);
            // Fetch and set Question
            Question question = questionRepository.findById(answerDto.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found with id: " + answerDto.getQuestionId()));
            answer.setQuestion(question);
            // Fetch and set Choice (if provided)
            if (answerDto.getChoiceId() != null) {
                Choice choice = choiceRepository.findById(answerDto.getChoiceId())
                        .orElseThrow(() -> new RuntimeException("Choice not found with id: " + answerDto.getChoiceId()));
                answer.setChoiceOption(choice);
            }
            // Set text answer (if provided)
            if (answerDto.getTextAnswer() != null) {
                answer.setTextAnswer(answerDto.getTextAnswer());
            }
            answers.add(answer);
        }
        response.setAnswers(answers);
        // 4. Save response and return dto
//        return convertToDto(responseRepository.save(response));
        return responseRepository.save(response);
    }

//    private ResponseDto convertToDto(Response response) {
//        return new ResponseDto(
//                response.getId(),
//                response.getSurvey() != null ? response.getSurvey().getId() : null,
//                response.getAnswers() != null
//                        ? response.getAnswers().stream()
//                        .map(answer -> new AnswerDto(
//                                answer.getId(),
//                                answer.getQuestion() != null ? answer.getQuestion().getId() : null,
//                                answer.getChoiceOption() != null ? answer.getChoiceOption().getId() : null,
//                                answer.getTextAnswer()
//                        ))
//                        .toList()
//                        : List.of(),
//                response.getSubmittedAt()
//        );
//    }

}
