package Dto;

import lombok.Data;
import za.co.teama.data.pulse.Models.Choice;
import za.co.teama.data.pulse.Models.Question;

@Data
public class AnswerDto {
    private Integer id;
    private Integer questionId;
    private Integer choiceId;
    private String textAnswer;

    public AnswerDto(Integer id, Integer integer, Integer integer1, String textAnswer) {
    }
}
