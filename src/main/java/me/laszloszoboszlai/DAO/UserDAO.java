package me.laszloszoboszlai.DAO;

import me.laszloszoboszlai.Entity.User;

import java.util.Collection;

/**
 * Created by laci on 02/07/2017.
 */
public interface UserDAO {
    Collection<User> getAllUsers();

    User getUserById(int id);

    void deleteUserById(int id);

    User getUserByCredentials(String email, String password);

    void updateUserBy(User user);

    void registerUser(User user);

    User findUserByName(String userName);

    boolean isUserExists(User user);
}
