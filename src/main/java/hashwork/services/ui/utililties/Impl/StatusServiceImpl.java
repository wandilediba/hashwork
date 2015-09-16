package hashwork.services.ui.utililties.Impl;

import hashwork.domain.ui.util.Status;
import hashwork.repository.ui.utililties.Impl.StatusRepositoryImpl;
import hashwork.services.ui.utililties.StatusService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class StatusServiceImpl implements StatusService {

    @Override
    public Status findById(String id) {
        return new StatusRepositoryImpl().findById(id);
    }

    @Override
    public Status save(Status entity) {
        return new StatusRepositoryImpl().save(entity);
    }

    @Override
    public Status update(Status entity) {
        return new StatusRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Status entity) {
        new StatusRepositoryImpl().delete(entity);

    }

    @Override
    public Set<Status> findAll() {
        return new StatusRepositoryImpl().findAll();
    }
}
