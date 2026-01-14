package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import za.co.teama.data.pulse.Models.Choice;
import za.co.teama.data.pulse.Models.Question;

@Data
@AllArgsConstructor
public class ChoiceDto {
    private Integer id;
    private String optionText;
    private Integer questionId;

    public ChoiceDto(Choice choice) {
        this.id = choice.getId();
        this.optionText = choice.getOptionText();
        this.questionId = choice.getQuestion().getId();
    }

    public ChoiceDto() {}
}
