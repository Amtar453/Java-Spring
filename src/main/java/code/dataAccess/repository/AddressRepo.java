package code.dataAccess.repository;

import code.dataAccess.entity.*;
import code.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, AddressIdEntity> {
    AddressEntity findByStreetAndNumberAndLocality_PostalCodeAndLocality_City(String street, String number, String postalCode, String city);
}
