package code.dataAccess.repository;

import code.dataAccess.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepo extends JpaRepository<AuthorityEntity, Integer> {
}
