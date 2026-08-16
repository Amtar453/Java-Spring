package code.dataAccess.dao;

import code.dataAccess.entity.LocalityEntity;
import code.model.*;

public interface LocalityDataAccess {
    void save(Locality locality);
    Locality getById(String postalCode, String city);
}
