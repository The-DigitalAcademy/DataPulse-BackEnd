package za.co.teama.data.pulse.Service;

import Dto.UserDto;
import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Models.User;
import za.co.teama.data.pulse.Repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDto signupUser (User user) {

        return null;
    }

    public UserDto transformUserEntityToDto(User user) {
        return new UserDto(user.getEmail(), String.valueOf(user.getRole()),
                user.getId().toString(), user.getName(),user.getSurname());
    }
}
