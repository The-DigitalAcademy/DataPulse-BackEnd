package za.co.teama.data.pulse.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "surveys")
public class Survey {
    @Id
    private Integer id;
    private String  title;
    private String  description;
    private boolean  isOpen;
    private String  CreatedAt;

}
