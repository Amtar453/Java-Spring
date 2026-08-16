package code.dataAccess.dao;

import code.dataAccess.entity.*;
import code.dataAccess.repository.*;
import code.dataAccess.util.Converter;
import code.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDAO implements UserDataAccess {
    private final UserRepo userRepo;
    private final Converter converter;

    private final AuthorityDataAccess authorityDAO;
    private final AddressDataAccess addressDAO;

    @Autowired
    public UserDAO(UserRepo userRepo, Converter converter, AuthorityDataAccess authorityDAO, AddressDataAccess addressDAO) {
        this.userRepo = userRepo;
        this.converter = converter;

        this.authorityDAO = authorityDAO;
        this.addressDAO = addressDAO;
    }

    // CREATE
    @Transactional
    public void save(User user) {
        UserEntity userEntity = new UserEntity();
        AddressEntity addressEntity = new AddressEntity();
        LocalityEntity localityEntity = new LocalityEntity();
        Address address = user.getAddress();

        userEntity.setName(user.getName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setEmail(user.getEmail());

        localityEntity.setPostalCode(user.getAddress().getLocality().getPostalCode());
        localityEntity.setCity(user.getAddress().getLocality().getCity());
        addressEntity.setNumber(address.getNumber());
        addressEntity.setStreet(address.getStreet());
        addressEntity.setLocality(localityEntity);

        userEntity.setAddress(addressEntity);

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setGender(user.getGender());
        userEntity.setEnabled(user.isEnabled());

        addressDAO.save(user.getAddress());
        userRepo.save(userEntity);
        authorityDAO.save(user.getUsername());
    }

    // READ
    public User getUserByUsername(String username) {
        UserEntity userEntity = userRepo.findByUsername(username);

        return userEntity == null ? null : converter.userEtoM(userEntity);
    }

    public User getUserByEmail(String email) {
        UserEntity user = userRepo.findByEmail(email);
        return user == null ? null : converter.userEtoM(user);
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        UserEntity user = userRepo.findByPhoneNumber(phoneNumber);
        return user == null ? null : converter.userEtoM(user);
    }

    // UPDATE
    public void update(User user) {
        userRepo.save(converter.userMtoE(user));
    }
}
