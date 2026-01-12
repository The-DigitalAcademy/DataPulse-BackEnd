package za.co.teama.data.pulse.Controller;

import Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping("/respondent")
    public ResponseEntity<UserDto> getRegisteruser(@RequestBody User user) {
        UserDto object = authenticationService.registerUser(user);
        return ResponseEntity.ok().body(object);
    }

    // auth controller incomplete - register coordinator user
    @PostMapping("/coordinator")
    public ResponseEntity<UserDto> registerCoordinatorUser(@RequestBody User user) {
        //Must return userDto with role of coordinator
        var createdCoordinatorUser = this.authenticationService.registerCoordinatorUser(user);
        return ResponseEntity.ok().body(createdCoordinatorUser);
    }

    // auth controller incomplete login - login respondent user and admin
    // instead of Object user correct response entity i.e UserDto
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginCredentials loginCredentials) {
      var users = authenticationService.login(loginCredentials);
      if(users == null) {
          // throw usernot found error
        return null;
      }
      return ResponseEntity.ok().body(users);
    }

}
