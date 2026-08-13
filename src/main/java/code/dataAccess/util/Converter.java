package code.dataAccess.util;

import code.dataAccess.entity.UserEntity;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import code.model.*;
import org.springframework.stereotype.Service;

@Service
public class Converter {
    private final Mapper mapper = new DozerBeanMapper();

    // User
    public User userEtoM(UserEntity userEntity) {
        return mapper.map(userEntity, User.class);
    }
    public UserEntity userMtoE(User user) {
        return mapper.map(user, UserEntity.class);
    }
}
