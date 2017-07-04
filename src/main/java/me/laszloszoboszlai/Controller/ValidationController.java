package me.laszloszoboszlai.Controller;

import me.laszloszoboszlai.Entity.User;
import me.laszloszoboszlai.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by laci on 04/07/2017.
 */
@RestController
@RequestMapping("/validate")
public class ValidationController {
    @Autowired
    private UserService userService;

    //method to validate user account
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }

}
