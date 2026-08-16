package code.dataAccess.dao;

import code.dataAccess.entity.AddressEntity;
import code.dataAccess.repository.AddressRepo;
import code.dataAccess.util.Converter;
import code.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressDAO implements AddressDataAccess{
    private final AddressRepo addressRepo;
    private final Converter converter;

    private final LocalityDataAccess localityDAO;

    @Autowired
    public AddressDAO(AddressRepo addressRepo, Converter converter,  LocalityDataAccess localityDAO) {
        this.addressRepo = addressRepo;
        this.converter = converter;
        this.localityDAO = localityDAO;
    }

    // CREATE
    public void save(Address address){
        localityDAO.save(address.getLocality());
        addressRepo.save(converter.addressMtoE(address));
    }

    // READ
    public Address getById(String street, String number, String  localityPostalCode, String localityCity){
        AddressEntity addressE = addressRepo.findByStreetAndNumberAndLocality_PostalCodeAndLocality_City(street, number,  localityPostalCode, localityCity);

        return addressE == null ? null : converter.addressEtoM(addressE);
    }
}
