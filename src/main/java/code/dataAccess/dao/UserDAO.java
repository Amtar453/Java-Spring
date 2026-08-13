package code.dataAccess.dao;

import code.dataAccess.entity.UserEntity;
import code.dataAccess.repository.UserRepo;
import code.dataAccess.util.Converter;
import code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO implements UserDataAccess {
    private UserRepo userRepo;
    private Converter converter;

    @Autowired
    public UserDAO(UserRepo userRepo, Converter converter) {
        this.userRepo = userRepo;
        this.converter = converter;
    }

    public void createUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setFirstName(user.getFirst_name());
        userEntity.setPhoneNumber(user.getPhone_number());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        if (user.getGender() != null) {
            userEntity.setGender(user.getGender());
        }
        userEntity.setEnabled(user.isEnabled());

        userRepo.save(userEntity);
    }

    public User getUserByUsername(String username) {
        UserEntity userEntity = userRepo.findByUsername(username);
        return converter.userEtoM(userEntity);
    }
}
