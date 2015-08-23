package hashwork.services.ui.demographics.Impl;

import hashwork.domain.ui.demographics.RaceList;
import hashwork.repository.ui.demographics.Impl.RaceListRespositoryImpl;
import hashwork.repository.ui.demographics.RaceListRespository;
import hashwork.services.ui.demographics.RaceListService;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class RaceListServiceImpl implements RaceListService {
    private final RaceListRespository repo = new RaceListRespositoryImpl();
    @Override
    public RaceList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public RaceList save(RaceList entity) {
        return repo.save(entity);
    }

    @Override
    public RaceList update(RaceList entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(RaceList entity) {
        repo.delete(entity);

    }

    @Override
    public Set<RaceList> findAll() {
        return repo.findAll();
    }
}
