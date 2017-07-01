package me.laszloszoboszlai.DAO;

import me.laszloszoboszlai.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Laszlo Szoboszlai on 01/07/2017.
 * Mock User repository.
 */
@Repository
public class UserDAO {
    private static Map<Integer, User> users;
    static{
        users = new HashMap<Integer, User>(){
            {
                put(1, new User(1,"John","Lennon","j@gmail.com","johnny",true));
                put(2, new User(2,"Alice","Cooper","ac@yahoo.com","cooper11",false));
                put(3, new User(3,"Axel","Rose","xl.rose@gmail.com","guns",true));
            }
        };
    }

    public Collection<User> getAllUsers(){
        return this.users.values();
    }

}
