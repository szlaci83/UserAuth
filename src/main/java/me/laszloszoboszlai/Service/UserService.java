package me.laszloszoboszlai.Service;

import me.laszloszoboszlai.DAO.UserDAO;
import me.laszloszoboszlai.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by laci on 01/07/2017.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    public Collection<User> getAllUsers(){
        return userDao.getAllUsers();
    }
}
