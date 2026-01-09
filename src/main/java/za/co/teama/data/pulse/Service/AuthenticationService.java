package za.co.teama.data.pulse.Service;

import Dto.UserDto;
import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Models.LoginCredentials;
import za.co.teama.data.pulse.Models.User;
import za.co.teama.data.pulse.Repository.UserRepository;

import java.util.UUID;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    // constructor injecting userRepository
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // incomplete - use userRepository to write to our db.
    public UserDto registerUser(User newUser) {
        newUser.setId(UUID.randomUUID());
        User object = this.userRepository.save(newUser);
        UserDto  dto = transformEntityToDto(object);
        return dto;
    }

    // incomplete
    public UserDto registerCoordinatorUser(User newCoordinatorUser) {
        return null;
    }

    // incomplete
    //
    public UserDto login(LoginCredentials loginCredentials) {
        return null;
    }

    // adapt entity to userDto
    public UserDto transformEntityToDto(User user) {
        return new UserDto(user.getId().toString(), user.getEmail(), user.getName(), user.getSurname(), String.valueOf(user.getRole()));
    }

    // check user exists by email
    private boolean checkUserByEmail(String userEmail) {
        return false;
    }
}
