package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.teama.data.pulse.Models.Question;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDto {
    private Integer id;
    private String title;
    private String description;
    private boolean isOpen;
    private CreatorDto coordinator;
    private List<QuestionDto> questions;
    private LocalDateTime createdAt;
    private List<Long> responseIds;

}