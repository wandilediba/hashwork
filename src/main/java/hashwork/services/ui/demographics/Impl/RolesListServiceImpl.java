package hashwork.services.ui.demographics.Impl;

import hashwork.domain.ui.demographics.RolesList;
import hashwork.repository.ui.demographics.Impl.RolesListRepositoryImpl;
import hashwork.repository.ui.demographics.RolesListRepository;
import hashwork.services.ui.demographics.RolesListService;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class RolesListServiceImpl implements RolesListService {
    private RolesListRepository repo = new RolesListRepositoryImpl();
    @Override
    public RolesList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public RolesList save(RolesList entity) {
        return repo.save(entity);
    }

    @Override
    public RolesList update(RolesList entity) {
        return repo.update(entity);
    }

    @Override
    public void delete(RolesList entity) {
        repo.delete(entity);

    }

    @Override
    public Set<RolesList> findAll() {
        return repo.findAll();
    }
}
