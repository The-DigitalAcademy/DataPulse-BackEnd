package za.co.teama.data.pulse.Service;

import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
