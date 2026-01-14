package za.co.teama.data.pulse.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "surveys")
@ToString(exclude = {"questions", "responses"}) // exclude these from lombok, they may cause infinite loops
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  title;
    private boolean  isOpen;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinator_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User coordinator;

    // Questions of this Survey
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();


    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Responses submitted by users
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private List<Response> responses = new ArrayList<>();

    // Helper method to set bidirectional relationship
    public void addQuestion(Question question) {
        questions.add(question);
        question.setSurvey(this);
    }

    public void setQuestions(List<Question> questions) {
        this.questions.clear();
        if (questions != null) {
            questions.forEach(this::addQuestion);
        }
    }

    // custom toSrting method
//    @Override
//    public String toString() {
//        return "Survey{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", isOpen=" + isOpen +
//                ", numOfQuestions=" + (questions != null ? questions.size() : 0) +
//                '}';
//    }
}
