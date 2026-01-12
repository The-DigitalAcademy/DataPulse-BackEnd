package za.co.teama.data.pulse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.teama.data.pulse.Models.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
