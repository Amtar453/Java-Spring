package code.service;

import code.dataAccess.dao.UserDataAccess;
import code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplementation implements UserDetailsService {
    private UserDataAccess userDataAccess;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsImplementation(UserDataAccess userDataAccess,  PasswordEncoder passwordEncoder) {
        this.userDataAccess = userDataAccess;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDataAccess.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public boolean isUsernameAvailable(String username) {
        return userDataAccess.getUserByUsername(username) == null;
    }

    public void registerUser(String username, String rawPassword) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(rawPassword)); // BCrypt
        newUser.setEnabled(true);
        userDataAccess.createUser(newUser);
    }

}
