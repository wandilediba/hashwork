package hashwork.services.ui.demographics.Impl;

import hashwork.domain.ui.demographics.GenderList;
import hashwork.repository.ui.demographics.GenderListRepository;
import hashwork.repository.ui.demographics.Impl.GenderListRepositoryImpl;
import hashwork.services.ui.demographics.GenderListService;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class GenderListServiceImpl implements GenderListService {
    private final GenderListRepository repo = new GenderListRepositoryImpl();

    @Override
    public GenderList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public GenderList save(GenderList entity) {
        return repo.save(entity);
    }

    @Override
    public GenderList update(GenderList entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(GenderList entity) {
        repo.delete(entity);
    }

    @Override
    public Set<GenderList> findAll() {
        return repo.findAll();
    }
}
