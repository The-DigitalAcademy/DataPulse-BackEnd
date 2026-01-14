package Dto;

import za.co.teama.data.pulse.Models.Answer;
import za.co.teama.data.pulse.Models.Survey;

import java.util.List;

public class ResponseDto {
    private Integer id;
    private Integer surveyIds;
    private List<AnswerDto> answers;
}