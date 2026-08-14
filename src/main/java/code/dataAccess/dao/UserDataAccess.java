package code.dataAccess.dao;

import code.model.User;

public interface UserDataAccess {
    void save(User user);
    User getUserByUsername(String username);
}
