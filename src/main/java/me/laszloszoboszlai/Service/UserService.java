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
    }
}
