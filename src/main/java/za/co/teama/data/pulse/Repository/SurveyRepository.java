package za.co.teama.data.pulse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.teama.data.pulse.Models.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {}
