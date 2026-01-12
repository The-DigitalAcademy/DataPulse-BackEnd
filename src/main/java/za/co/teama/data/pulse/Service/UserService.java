package za.co.teama.data.pulse.Service;

import Dto.UserDto;
import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Models.LoginCredentials;
import za.co.teama.data.pulse.Models.User;
import za.co.teama.data.pulse.Repository.UserRepository;
import za.co.teama.data.pulse.Service.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public UserDto signinUser(LoginCredentials loginCredentials) {
      User obj = this.userRepository.findByEmail(loginCredentials.getEmail());
      UserDto dto = transformUserEntityToDto(obj);
      return dto;
    }

    public UserDto signupUser (User user) {

        return null;
    }
    public User getUserByEmail (User user){
//      userRepository.
      return user;
    }

    public UserDto transformUserEntityToDto(User user) {
        return new UserDto(user.getId().toString(), user.getName() +" "+ user.getSurname(), user.getEmail(), String.valueOf(user.getRole()));
    }
}
