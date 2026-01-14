package za.co.teama.data.pulse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.teama.data.pulse.Models.Choice;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Integer> {
}
