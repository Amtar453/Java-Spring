package code.dataAccess.dao;

import code.dataAccess.entity.LocalityEntity;
import code.dataAccess.repository.LocalityRepo;
import code.dataAccess.util.Converter;
import code.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalityDAO implements LocalityDataAccess{
    private final LocalityRepo localityRepo;
    private final Converter converter;

    @Autowired
    public LocalityDAO(LocalityRepo localityRepo, Converter converter) {
        this.localityRepo = localityRepo;
        this.converter = converter;
    }

    // CREATE
    public void save(Locality locality){
        localityRepo.save(converter.localityMtoE(locality));
    }
    
    // READ
    public Locality getById(String postalCode, String city){
        LocalityEntity localityE = localityRepo.findByPostalCodeAndCity(postalCode, city);

        return localityE == null ? null : converter.localityEtoM(localityE);
    }
}
