package Dto;

import za.co.teama.data.pulse.Models.Choice;
import za.co.teama.data.pulse.Models.Survey;

import java.util.List;

public class QuestionDto {
    private Integer id;
    private String text;
    private List<ChoiceDto> choiceOptions;

    public QuestionDto(Integer id, String text, List<ChoiceDto> choiceOptions) {
        this.id = id;
        this.text = text;
        this.choiceOptions = choiceOptions;
    }

    public QuestionDto() {}

}
