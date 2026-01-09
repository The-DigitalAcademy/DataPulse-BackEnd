package za.co.teama.data.pulse.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK -  references a Response record
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "response_id", nullable = false)
    private Response response;

    // FK -  references a question
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // FK -  references the selected Choice (1 of 5 options)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "choice_id")
    private Choice choiceOption;

    @Column(columnDefinition = "TEXT")
    private String textAnswer;
}
