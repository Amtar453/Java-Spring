package code.dataAccess.repository;

import code.dataAccess.entity.UserEntity;
import code.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
    UserEntity findByPhoneNumber(String phoneNumber);
}
