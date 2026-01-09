package za.co.teama.data.pulse.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String optionText;

    // FK - maps this Choice to a Survey question.
    // A survey question has 5 of these `Choices`
    // Line 26 in Question.java
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
