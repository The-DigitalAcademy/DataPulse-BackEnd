package za.co.teama.data.pulse.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Answer {
    @Id
    private Integer id;
    private Integer submissionId;
    private Integer choiceId;
    private Integer questionId;
}
