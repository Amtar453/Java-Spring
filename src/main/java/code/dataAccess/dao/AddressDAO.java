package code.dataAccess.dao;

import code.dataAccess.repository.AddressRepo;
import code.dataAccess.util.Converter;
import code.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressDAO implements AddressDataAccess{
    private AddressRepo addressRepo;
    private Converter converter;

    @Autowired
    public AddressDAO(AddressRepo addressRepo, Converter converter) {
        this.addressRepo = addressRepo;
        this.converter = converter;
    }

    public void save(Address address){
        addressRepo.save(converter.addressMtoE(address));
    }
}
