package za.co.teama.data.pulse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.teama.data.pulse.Models.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
