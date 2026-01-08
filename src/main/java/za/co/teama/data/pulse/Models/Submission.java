package za.co.teama.data.pulse.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Submission {
    @Id
    private Integer id;
    private Integer surveyId;
    private String userId;
}
