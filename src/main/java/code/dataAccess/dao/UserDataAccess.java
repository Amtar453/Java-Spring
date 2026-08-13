package code.dataAccess.dao;

import code.model.User;

public interface UserDataAccess {
    void createUser(User user);
    User getUserByUsername(String username);
}
