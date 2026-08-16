package code.dataAccess.repository;

import code.dataAccess.entity.*;
import code.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepo extends JpaRepository<LocalityEntity, LocalityIdEntity> {
    LocalityEntity findByPostalCodeAndCity(String postalCode, String city);
}
