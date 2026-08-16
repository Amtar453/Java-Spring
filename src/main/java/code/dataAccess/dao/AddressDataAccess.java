package code.dataAccess.dao;

import code.model.Address;

public interface AddressDataAccess {
    void save(Address address);
    Address getById(String street, String number, String localityPostalCode, String localityCity);
}
