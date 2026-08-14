package code.dataAccess.repository;

import code.dataAccess.entity.*;
import code.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalityRepo extends JpaRepository<LocalityEntity, LocalityIdEntity> {
}
