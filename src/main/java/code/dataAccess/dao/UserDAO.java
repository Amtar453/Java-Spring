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
    private UserRepo userRepo;
    private Converter converter;

    private AuthorityDataAccess authorityDAO;
    private LocalityDataAccess localityDao;

    @Autowired
    public UserDAO(UserRepo userRepo, Converter converter, AuthorityDataAccess authorityDAO, LocalityDataAccess localityDao) {
        this.userRepo = userRepo;
        this.converter = converter;

        this.authorityDAO = authorityDAO;
        this.localityDao = localityDao;
    }


    @Transactional
    public void save(User user) {
        UserEntity userEntity = new UserEntity();
        LocalityEntity localityEntity = new LocalityEntity();
        AddressEntity addressEntity = new AddressEntity();
        Address address = user.getLocality().getAddress();

        userEntity.setName(user.getName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setEmail(user.getEmail());

        localityEntity.setPostalCode(user.getLocality().getPostalCode());
        localityEntity.setCity(user.getLocality().getCity());
        addressEntity.setNumber(address.getNumber());
        addressEntity.setStreet(address.getStreet());
        localityEntity.setAddressEntity(addressEntity);

        userEntity.setLocality(localityEntity);

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setGender(user.getGender());
        userEntity.setEnabled(user.isEnabled());

        localityDao.save(user.getLocality());
        userRepo.save(userEntity);
        authorityDAO.save(user.getUsername());
    }

    public User getUserByUsername(String username) {
        UserEntity userEntity = userRepo.findByUsername(username);

        return userEntity == null ? null : converter.userEtoM(userEntity);
    }
}
