package za.co.teama.data.pulse.Service;

import Dto.UserDto;
import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Models.LoginCredentials;
import za.co.teama.data.pulse.Models.User;
import za.co.teama.data.pulse.Repository.UserRepository;
import za.co.teama.data.pulse.Service.interfaces.AuthenticationServiceInterface;
import za.co.teama.data.pulse.exceptions.InvalidLoginDetailsException;
import za.co.teama.data.pulse.exceptions.UserExistsException;
import za.co.teama.data.pulse.exceptions.UserNotFoundException;
import java.util.UUID;

@Service
public class AuthenticationService implements AuthenticationServiceInterface {

    private final UserRepository userRepository;

    // constructor injecting userRepository
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * First check if user entity with given email exists - checkUserByEmail(newUser.getEmail())
     * if exists throw exception at line 37.
     * @param newUser - new user to create.
     * @return created user dto.
     */
    public UserDto registerUser(User newUser) {
        if(!checkUserByEmail(newUser.getEmail())) {
            newUser.setId(UUID.randomUUID());
            User object = this.userRepository.save(newUser);
            UserDto  dto = transformEntityToDto(object);
            return dto;
        }
        else {
            throw new UserExistsException("user account already exists");
        }
    }

    /**
     * reuse register method. the role is set int the front end logic.
     * @param newCoordinatorUser - coordinator to create
     * @return userDto
     */
    public UserDto registerCoordinatorUser(User newCoordinatorUser) {
        return registerUser(newCoordinatorUser);
    }

    // incomplete
    //
    public UserDto login(LoginCredentials loginCredentials) {
      var user = userRepository.findByEmail(loginCredentials.getEmail());
      if(user == null) {
        throw new UserNotFoundException("User not found.");
      }
      // check if the password matches
      if(user.getPassword().equals(loginCredentials.getPassword())){
          var userDto = transformEntityToDto(user);
        return userDto;
      }else {
          throw new InvalidLoginDetailsException("invalid login details.");
      }
    }

    // adapt entity to userDto
    public UserDto transformEntityToDto(User user) {
        return new UserDto(user.getId().toString(), user.getEmail(), user.getName(), user.getSurname(), String.valueOf(user.getRole()));
    }

    /**
     * checks if there is a user entity with this email
     * @param userEmail -
     * @return true - user exists with this email.
     * @return false - user with this email does not exist.
     */
    private boolean checkUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail) != null;
    }
}
