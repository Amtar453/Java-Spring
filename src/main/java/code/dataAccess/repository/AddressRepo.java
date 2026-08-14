package code.dataAccess.repository;

import code.dataAccess.entity.*;
import code.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<AddressEntity, AddressIdEntity> {
}
