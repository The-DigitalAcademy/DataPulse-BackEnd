package za.co.teama.data.pulse.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "surveys")
public class Survey {
    @Id
    private Long id;
    private String title;
    private String description;
    private Boolean isOpen;
    private LocalDateTime createAt;

}
