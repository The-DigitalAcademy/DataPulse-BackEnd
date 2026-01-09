package za.co.teama.data.pulse.Controller;

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
  private AuthenticationService authenticationService;

  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }
  // use authService, pass incoming data from request to appropriate service methods


    // auth controller incomplete - register respondent user
    @PostMapping("/respondent")
    public ResponseEntity<Object> registerUser(@RequestBody User userDto) {

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
    public String login(@RequestBody LoginCredentials loginCredentials) {
      var users = authenticationService.login(loginCredentials);

      if(users == null) {
        return "User not recognized";
      }

      return "Logged in successfully";
    }

}
