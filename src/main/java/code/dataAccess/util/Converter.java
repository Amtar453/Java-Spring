package code.dataAccess.util;

import code.dataAccess.entity.*;
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

    // Address
    public Address addressEtoM(AddressEntity addressEntity) {
        return mapper.map(addressEntity, Address.class);
    }
    public AddressEntity addressMtoE(Address address) {
        return mapper.map(address, AddressEntity.class);
    }

    // Locality
    public Locality localityEtoM(LocalityEntity localityEntity) {
        return mapper.map(localityEntity, Locality.class);
    }
    public LocalityEntity localityMtoE(Locality locality) {
        return mapper.map(locality, LocalityEntity.class);
    }
}
