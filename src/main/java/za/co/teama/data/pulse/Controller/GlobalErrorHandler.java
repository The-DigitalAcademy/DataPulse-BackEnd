package za.co.teama.data.pulse.Controller;

import Dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import za.co.teama.data.pulse.exceptions.InvalidLoginDetailsException;
import za.co.teama.data.pulse.exceptions.UserExistsException;
import za.co.teama.data.pulse.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalErrorHandler {

    // class constant strings.
    public static String USER_DOES_NOT_EXIST = "User does not exist.";
    public static String USER_ALREADY_EXIST = "User already exists.";

    /**
     * Custom error handling for our application, thrown if user is not found
     * usage - login logic.
     * @param message - text that is sent to the front application. simple text for error description
     * @return  REST -ResponseEntity with errorDto object
     */
    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ErrorDto> userNotFound(String message){
        ErrorDto responseDto = new ErrorDto();
        responseDto.setMessage(String.format(USER_DOES_NOT_EXIST, message));
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    /**
     * Custom error handling for our application, thrown if duplicate user email is being used
     * usage - register logic.
     * @param message - text that is sent to the front application. simple text for error description
     * @return  REST -ResponseEntity with errorDto object
     */
    @ExceptionHandler({UserExistsException.class})
    public ResponseEntity<ErrorDto> userAlreadyExists(String message){
        ErrorDto responseDto = new ErrorDto();
        responseDto.setMessage(String.format(USER_ALREADY_EXIST, message));
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    /**
     * usage -login logic line 63
     * @param message - invalid login details
     * @return
     */
    @ExceptionHandler({InvalidLoginDetailsException.class})
    public ResponseEntity<ErrorDto> invalidLoginDetails(String message) {
        ErrorDto responseDto = new ErrorDto();
        responseDto.setMessage(message);
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
