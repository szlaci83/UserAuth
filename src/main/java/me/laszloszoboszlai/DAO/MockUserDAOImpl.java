package me.laszloszoboszlai.DAO;

import me.laszloszoboszlai.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Laszlo Szoboszlai on 01/07/2017.
 * Mock User repository.
 */
@Repository
@Qualifier("Mock data")
public class MockUserDAOImpl implements UserDAO {
    private static Map<Integer, User> users;
    static{
        users = new HashMap<Integer, User>(){
            {
                put(1, new User(1,"johnny", "John","Lennon","j@gmail.com","johnny",true));
                put(2, new User(2,"alice","Alice","Cooper","ac@yahoo.com","cooper11",false));
                put(3, new User(3,"xl","Axel","Rose","xl.rose@gmail.com","guns",true));
            }
        };
    }

    @Override
    public Collection<User> getAllUsers(){
        return this.users.values();
    }

    @Override
    public User getUserById(int id){
        return this.users.get(id);
    }

    @Override
    public void deleteUserById(int id) {
        this.users.remove(id);
    }

    @Override
    public User getUserByCredentials(String email, String password) {
        //TODO:
        return this.users.get(1);
    }

    @Override
    public void updateUserBy(User user){
        User newUser = users.get(user.getId());

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setConfirmed(user.isConfirmed());

        users.put(user.getId(), user);
    }

    @Override
    public void registerUser(User user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public User findUserByName(String userName) {
        return null;
    }
}
