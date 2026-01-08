package za.co.teama.data.pulse.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    private Integer id;
    private String text;
    private Integer surveyId;
}
