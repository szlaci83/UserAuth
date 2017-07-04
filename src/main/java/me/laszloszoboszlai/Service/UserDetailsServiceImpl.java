/**package me.laszloszoboszlai.Service;

import me.laszloszoboszlai.DAO.MySqlUserDAO;
import me.laszloszoboszlai.Entity.Role;
import me.laszloszoboszlai.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;


 * Created by laci on 03/07/2017.

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MySqlUserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findUserByName(userName);
        if(user != null) {
            String password = user.getPassword();
            boolean enabled = user.isConfirmed();
            boolean accountNonExpired = user.isConfirmed();
            boolean credentialsNonExpired = user.isConfirmed();
            boolean accountNonLocker = user.isConfirmed();

            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (Role role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            }

            org.springframework.security.core.userdetails.User securityUser = new
                    org.springframework.security.core.userdetails.User(userName, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocker, authorities);
        return securityUser;
        }
        else throw new UsernameNotFoundException("User not found in database!");
    }

}

 */