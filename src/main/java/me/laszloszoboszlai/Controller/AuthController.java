package me.laszloszoboszlai.Controller;

import me.laszloszoboszlai.Entity.User;
import me.laszloszoboszlai.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by laci on 04/07/2017.
 */

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    //Method to authenicate a user, (return a token?)
    @RequestMapping(value = "/{email}/{password}", method = RequestMethod.GET)
    public User getUserByCredentials(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.getUserByCredentials(email, password);
    }

}
