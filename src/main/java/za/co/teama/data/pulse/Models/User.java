package za.co.teama.data.pulse.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;
@Data
@Entity(name =" users")
public class User {
    @Id
    private UUID id;
    private String  Name;
    private String surname;

    private String email;
    private String password;
    private String role;

    }


