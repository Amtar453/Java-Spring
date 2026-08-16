package code.dataAccess.dao;

import code.model.User;

public interface UserDataAccess {
    void save(User user);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    User getUserByPhoneNumber(String phoneNumber);
    void update(User user);
}
