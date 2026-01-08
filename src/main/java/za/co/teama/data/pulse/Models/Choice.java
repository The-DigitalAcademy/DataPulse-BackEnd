package za.co.teama.data.pulse.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Choice {
    private Integer id;
    private String text;
    private Integer questionId;
}
