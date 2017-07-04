package me.laszloszoboszlai.Controller;

import me.laszloszoboszlai.Entity.User;
import me.laszloszoboszlai.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by laci on 04/07/2017.
 */
@RestController
@RequestMapping("/validate")
public class ValidationController {
    @Autowired
    private UserService userService;

    //method to validate user account
    @RequestMapping(value = "/{email}/{hash}", method = RequestMethod.GET)
    public ResponseEntity<Void> getUserByEmail(@PathVariable("email") String email,
                                               @PathVariable("hash") int hash,
                                               UriComponentsBuilder ucBuilder){

        User theUser = userService.getUserByEmail(email);
        HttpHeaders headers = new HttpHeaders();

        if (theUser == null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        if (theUser.hashCode() == hash) {
            userService.validateUser(theUser);
            return new ResponseEntity<Void>(headers, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<Void>(headers, HttpStatus.EXPECTATION_FAILED);
    }

}
