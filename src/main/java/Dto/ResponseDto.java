package Dto;

import za.co.teama.data.pulse.Models.Answer;
import za.co.teama.data.pulse.Models.Survey;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseDto {
    private Integer id;
    private Integer surveyIds;
    private List<AnswerDto> answers;


    public ResponseDto(Integer id, Integer surveyId, List<AnswerDto> answers, LocalDateTime submittedAt) {
        this.id = id;
        this.surveyIds = surveyId;
        this.answers = answers;
    }
}
