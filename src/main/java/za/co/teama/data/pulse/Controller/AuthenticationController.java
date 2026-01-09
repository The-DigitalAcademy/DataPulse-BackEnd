package za.co.teama.data.pulse.Controller;

import Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.teama.data.pulse.Models.LoginCredentials;
import za.co.teama.data.pulse.Models.User;
import za.co.teama.data.pulse.Service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    // Inject authService
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
// use authService, pass incoming data from request to appropriate service methods


    // auth controller incomplete - register respondent user
    @PostMapping("/respondent")
    public ResponseEntity<UserDto> registerUser(@RequestBody User user) {

        // Must return userDto
        return null;
    }

    // auth controller incomplete - register coordinator user
    @PostMapping("/coordinator")
    public ResponseEntity<UserDto> registerCoordinatorUser(@RequestBody User user) {

        //Must return userDto with role of coordinator
        return null;
    }

    // auth controller incomplete login - login respondent user and admin
    // instead of Object user correct response entity i.e UserDto
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginCredentials loginCredentials) {

        // Must return userDto
        return null;
    }
}
