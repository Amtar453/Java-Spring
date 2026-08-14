package code.dataAccess.dao;

import code.dataAccess.repository.LocalityRepo;
import code.dataAccess.util.Converter;
import code.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalityDAO implements LocalityDataAccess{
    private LocalityRepo localityRepo;
    private Converter converter;
    private AddressDataAccess addressDao;

    @Autowired
    public LocalityDAO(LocalityRepo localityRepo, Converter converter, AddressDataAccess addressDao) {
        this.localityRepo = localityRepo;
        this.converter = converter;
        this.addressDao = addressDao;
    }

    public void save(Locality locality){
        addressDao.save(locality.getAddress());
        localityRepo.save(converter.localityMtoE(locality));
    }
}
