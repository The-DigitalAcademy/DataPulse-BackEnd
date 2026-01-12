package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDateTime createdAt;
    private List<Long> responseIds;

}