package za.co.teama.data.pulse.Service;

import Dto.AnswerDto;
import Dto.ResponseDto;
import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Models.Answer;
import za.co.teama.data.pulse.Models.Response;
import za.co.teama.data.pulse.Models.Survey;
import za.co.teama.data.pulse.Repository.ResponseRepository;

import java.util.List;

@Service
public class ResponseService {

    private final ResponseRepository responseRepo;

    public ResponseService(ResponseRepository responseRepo) { this.responseRepo = responseRepo; }

    //Get responses
    public List<Response> getResponses() {
        return responseRepo.findAll();
    }

    //Create Responses
    public ResponseDto addResponse(Response response) {
        // Set bidirectional relationships for answers
        if (response.getAnswers() != null) {
            for (Answer answer : response.getAnswers()) {
                answer.setResponse(response); // link answer back to this response
            }
        }

        // Save the response entity
        Response saved = responseRepo.save(response);

        // Convert the saved entity to DTO
        return convertToDto(saved);
    }

    private ResponseDto convertToDto(Response response) {
        return new ResponseDto(
                response.getId(),
                response.getSurvey() != null ? response.getSurvey().getId() : null,
                response.getAnswers() != null
                        ? response.getAnswers().stream()
                        .map(answer -> new AnswerDto(
                                answer.getId(),
                                answer.getQuestion() != null ? answer.getQuestion().getId() : null,
                                answer.getChoiceOption() != null ? answer.getChoiceOption().getId() : null,
                                answer.getTextAnswer()
                        ))
                        .toList()
                        : List.of(),
                response.getSubmittedAt()
        );
    }

}
