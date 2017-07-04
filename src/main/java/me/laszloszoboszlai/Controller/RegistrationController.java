package me.laszloszoboszlai.Controller;

import me.laszloszoboszlai.Entity.User;
import me.laszloszoboszlai.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by laci on 04/07/2017.
 */


@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    //method to register a user
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registerUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        if (userService.isUserExists(user)){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userService.registerUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    //method to grant roles....

}



