package me.laszloszoboszlai.Service;

import me.laszloszoboszlai.DAO.UserDAO;
import me.laszloszoboszlai.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by laci on 01/07/2017.
 */
@Service
public class UserService {
    @Autowired
    @Qualifier("mySqlData")
    private UserDAO userDao;

    @Autowired
    private MailServiceImpl mailService;

    public Collection<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public User getUserById(int id){
        return this.userDao.getUserById(id);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    public User getUserByCredentials(String email, String password) {
        return userDao.getUserByCredentials(email, password);
    }

    public void updateUser(User user){
        userDao.updateUserBy(user);
    }

    public void registerUser(User user) {
        userDao.registerUser(user);

        String validationUri = "localhost:8080/validate/"+user.getEmail()+"/" + user.hashCode();
        mailService.sendEmail(user.getEmail(), "validation@serice.com",
                "Login activation link inside!", "" +
                        "Thanks for registering, your validation URI is:" +
                        "\n" +
                        validationUri +
                        "\n copy and paste it to your browser to validate your account! :D "   );
    }

    public boolean isUserExists(User user) { return userDao.isUserExists(user);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public void validateUser(User theUser) {
        userDao.validateUser(theUser);
    }

}
