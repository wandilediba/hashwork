package hashwork.services.ui.utililties.Impl;

import hashwork.domain.ui.util.AccidentTypeList;
import hashwork.repository.ui.utililties.Impl.AccidentTypeListRepositoryImpl;
import hashwork.services.ui.utililties.AccidentTypeListService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class AccidentTypeListServiceImpl implements AccidentTypeListService {

    @Override
    public AccidentTypeList findById(String id) {
        return new AccidentTypeListRepositoryImpl().findById(id);
    }

    @Override
    public AccidentTypeList save(AccidentTypeList entity) {
        return new AccidentTypeListRepositoryImpl().save(entity);
    }

    @Override
    public AccidentTypeList update(AccidentTypeList entity) {
        return new AccidentTypeListRepositoryImpl().update(entity);
    }

    @Override
    public void delete(AccidentTypeList entity) {
        new AccidentTypeListRepositoryImpl().delete(entity);

    }

    @Override
    public Set<AccidentTypeList> findAll() {
        return new AccidentTypeListRepositoryImpl().findAll();
    }
}
