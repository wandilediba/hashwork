package hashwork.services.ui.demographics.Impl;

import hashwork.domain.ui.demographics.MaritalStatusList;
import hashwork.repository.ui.demographics.Impl.MaritalStatusListRepositoryImpl;
import hashwork.repository.ui.demographics.MaritalStatusListRepository;
import hashwork.services.ui.demographics.MaritalStatusListService;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class MaritalStatusListServiceImpl implements MaritalStatusListService {
    private final MaritalStatusListRepository repo = new MaritalStatusListRepositoryImpl();
    @Override
    public MaritalStatusList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public MaritalStatusList save(MaritalStatusList entity) {
        return repo.save(entity);
    }

    @Override
    public MaritalStatusList update(MaritalStatusList entity) {
        return repo.update(entity);
    }

    @Override
    public void delete(MaritalStatusList entity) {
        repo.delete(entity);

    }

    @Override
    public Set<MaritalStatusList> findAll() {
        return repo.findAll();
    }
}
