package hashwork.services.ui.utililties.Impl;

import hashwork.domain.ui.util.Funder;
import hashwork.repository.ui.utililties.Impl.FunderRepositoryImpl;
import hashwork.services.ui.utililties.FunderService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class FunderServiceImpl implements FunderService {

    @Override
    public Funder findById(String id) {
        return new FunderRepositoryImpl().findById(id);
    }

    @Override
    public Funder save(Funder entity) {
        return new FunderRepositoryImpl().save(entity);
    }

    @Override
    public Funder update(Funder entity) {
        return new FunderRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Funder entity) {
        new FunderRepositoryImpl().delete(entity);

    }

    @Override
    public Set<Funder> findAll() {
        return new FunderRepositoryImpl().findAll();
    }
}
