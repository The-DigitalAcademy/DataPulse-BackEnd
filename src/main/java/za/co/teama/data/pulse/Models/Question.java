package za.co.teama.data.pulse.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString(exclude = {"survey", "choices"}) // exclude these from lombok, they may cause infinite loops
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String text;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false) // FK - maps to Survey
    private Survey survey;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Choice> choiceOptions = new ArrayList<>();

    // Helper method for bidirectional relationship
    public void addChoice(Choice choice) {
        choiceOptions.add(choice);
        choice.setQuestion(this);
    }

    public void setChoices(List<Choice> choices) {
        this.choiceOptions.clear();
        if (choices != null) {
            choices.forEach(this::addChoice);
        }
    }
}
