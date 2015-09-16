package hashwork.services.ui.demographics.Impl;

import hashwork.domain.ui.demographics.TitleList;
import hashwork.repository.ui.demographics.Impl.TitleListRespositoryImpl;
import hashwork.repository.ui.demographics.TitleListRespository;
import hashwork.services.ui.demographics.TitleListService;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class TitleListServiceImpl implements TitleListService {
    private TitleListRespository repo = new TitleListRespositoryImpl();
    @Override
    public TitleList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public TitleList save(TitleList entity) {
        return repo.save(entity);
    }

    @Override
    public TitleList update(TitleList entity) {
        return repo.update(entity);
    }

    @Override
    public void delete(TitleList entity) {
        repo.delete(entity);

    }

    @Override
    public Set<TitleList> findAll() {
        return repo.findAll();
    }
}
