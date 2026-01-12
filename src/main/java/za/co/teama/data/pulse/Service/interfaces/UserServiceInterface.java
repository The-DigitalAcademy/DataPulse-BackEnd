package za.co.teama.data.pulse.Service.interfaces;

import Dto.UserDto;
import za.co.teama.data.pulse.Models.LoginCredentials;
import za.co.teama.data.pulse.Models.User;

public interface UserServiceInterface {
    public User createUser(User user);
    public UserDto signinUser(LoginCredentials loginCredentials);
    public UserDto signupUser (User user);
    public User getUserByEmail (User user);
    public UserDto transformUserEntityToDto(User user);
}
