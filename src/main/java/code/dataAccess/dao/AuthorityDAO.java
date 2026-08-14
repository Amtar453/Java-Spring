package code.dataAccess.dao;

import code.dataAccess.entity.AuthorityEntity;
import code.dataAccess.repository.AuthorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityDAO implements AuthorityDataAccess{
    private AuthorityRepo authorityRepo;

    @Autowired
    public AuthorityDAO(AuthorityRepo authorityRepo) {
        this.authorityRepo = authorityRepo;
    }

    public void save(String username) {
        AuthorityEntity authority = new AuthorityEntity();

        authority.setUsername(username);
        authority.setLabel("CLIENT");
        authorityRepo.save(authority);
    }
}
