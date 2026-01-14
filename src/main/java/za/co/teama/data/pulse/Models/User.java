package za.co.teama.data.pulse.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name ="users")
//@ToString(exclude = {"surveys", "responses"}) // exclude these from lombok, they may cause infinite loops
public class User {
    @Id
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    // Relationshhips with other entities

    @OneToMany(mappedBy = "coordinator", cascade = CascadeType.ALL)
    private List<Survey> createdSurveys = new ArrayList<>(); // only for coordinators

    @OneToMany(mappedBy = "respondent", cascade = CascadeType.ALL)
    private List<Response> surveyResponses = new ArrayList<>(); // only for respondents

}


