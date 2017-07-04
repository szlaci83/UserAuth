package me.laszloszoboszlai.Controller;

import me.laszloszoboszlai.Entity.User;
import me.laszloszoboszlai.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by laci on 04/07/2017.
 */

@RestController
@RequestMapping("/authorise")
public class AuthController {
    @Autowired
    private UserService userService;

    //Simple authentication returns the user
    @RequestMapping(value = "/{email}/{password}", method = RequestMethod.GET)
    public ResponseEntity SimpleAuthentication(@PathVariable("email") String email,
                                               @PathVariable("password") String password,
                                               UriComponentsBuilder ucBuilder) {
        User theUser = userService.getUserByCredentials(email, password);
        /*if (! userService.isUserExists(theUser)){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
        HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(theUser.getId()).toUri());
        HttpEntity<User> entity = new HttpEntity<User>(theUser);
        return new ResponseEntity<>(theUser, HttpStatus.FOUND);
    }

    /*//token based auth....
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user){
        userService.getToken(user);
    }
    */



}
