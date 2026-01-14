package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private Integer id;
    private String text;
    private List<ChoiceDto> choiceOptions;

}
