package Dto;

import lombok.Data;
import za.co.teama.data.pulse.Models.Answer;
import za.co.teama.data.pulse.Models.Survey;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResponseDto {
    private Integer surveyId;
    private String userId;
    private List<AnswerDto> answers;
    private String submittedAt;
}
