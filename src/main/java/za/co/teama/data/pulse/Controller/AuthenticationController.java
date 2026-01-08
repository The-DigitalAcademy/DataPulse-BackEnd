package za.co.teama.data.pulse.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.teama.data.pulse.Models.LoginCredentials;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    // Inject authService


    // use authService, pass incoming data from request to appropriate service methods


    // auth controller incomplete - register respondent user
    @PostMapping("/respondent")
    public ResponseEntity<Object> registerUser(@RequestBody Object userDto) {

        // Must return userDto
        return null;
    }

    // auth controller incomplete - register coordinator user
    @PostMapping("/coordinator")
    public ResponseEntity<Object> registerCoordinatorUser(@RequestBody Object userDto) {

        //Must return userDto with role of coordinator
        return null;
    }

    // auth controller incomplete login - login respondent user and admin
    // instead of Object user correct response entity i.e UserDto
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginCredentials loginCredentials) {

        // Must return userDto
        return null;
    }
}
