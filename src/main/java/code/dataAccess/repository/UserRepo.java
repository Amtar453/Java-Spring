package code.dataAccess.repository;

import code.dataAccess.entity.UserEntity;
import code.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
