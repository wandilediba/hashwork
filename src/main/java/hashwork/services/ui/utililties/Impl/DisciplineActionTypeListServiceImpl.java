package hashwork.services.ui.utililties.Impl;

import hashwork.domain.ui.util.DisciplineActionTypeList;
import hashwork.repository.ui.utililties.Impl.DisciplineActionTypeListRepositoryImpl;
import hashwork.services.ui.utililties.DisciplineActionTypeListService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class DisciplineActionTypeListServiceImpl implements DisciplineActionTypeListService {

    @Override
    public DisciplineActionTypeList findById(String id) {
        return new DisciplineActionTypeListRepositoryImpl().findById(id);
    }

    @Override
    public DisciplineActionTypeList save(DisciplineActionTypeList entity) {
        return new DisciplineActionTypeListRepositoryImpl().save(entity);
    }

    @Override
    public DisciplineActionTypeList update(DisciplineActionTypeList entity) {
        return new DisciplineActionTypeListRepositoryImpl().update(entity);
    }

    @Override
    public void delete(DisciplineActionTypeList entity) {
        new DisciplineActionTypeListRepositoryImpl().delete(entity);

    }

    @Override
    public Set<DisciplineActionTypeList> findAll() {
        return new DisciplineActionTypeListRepositoryImpl().findAll();
    }
}

