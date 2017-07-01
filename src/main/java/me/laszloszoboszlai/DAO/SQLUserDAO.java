package me.laszloszoboszlai.DAO;

import me.laszloszoboszlai.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by laci on 02/07/2017.
 */

@Repository
@Qualifier("sqlData")
public class SQLUserDAO implements UserDAO{
    @Override
    public Collection<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public User getUserByCredentials(String email, String password) {
        return null;
    }

    @Override
    public void updateUserBy(User user) {

    }

    @Override
    public void registerUser(User user) {

    }
}
