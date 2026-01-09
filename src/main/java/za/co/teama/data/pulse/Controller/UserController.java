package za.co.teama.data.pulse.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.teama.data.pulse.Service.UserService;

@RestController
@RequestMapping ("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}


