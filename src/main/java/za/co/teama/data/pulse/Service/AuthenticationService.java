package za.co.teama.data.pulse.Service;

import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Models.LoginCredentials;
import za.co.teama.data.pulse.Models.User;
import za.co.teama.data.pulse.Repository.UserRepository;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    // constructor injecting userRepository
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // incomplete - use userRepository to write to our db.
    public Object registerUser(Object newUser) {
        return null;
    }

    // incomplete
    public Object registerCoordinatorUser(Object newCoordinatorUser) {
        return null;
    }

    // incomplete
    //
    public Object login(LoginCredentials loginCredentials) {
        return null;
    }

    // adapt entity to userDto
    public Object transformEntityToDto(User user) {
        return null;
    }

    // check user exists by email
    private boolean checkUserByEmail(String userEmail) {
        return false;
    }
}
