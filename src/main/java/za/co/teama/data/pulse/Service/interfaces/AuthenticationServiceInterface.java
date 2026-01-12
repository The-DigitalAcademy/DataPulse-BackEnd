package za.co.teama.data.pulse.Service.interfaces;

import Dto.UserDto;
import za.co.teama.data.pulse.Models.LoginCredentials;
import za.co.teama.data.pulse.Models.User;

public interface AuthenticationServiceInterface {
    public UserDto registerUser(User newUser);
    public UserDto registerCoordinatorUser(User newCoordinatorUser);
    public UserDto login(LoginCredentials loginCredentials);
    public UserDto transformEntityToDto(User user);
}
