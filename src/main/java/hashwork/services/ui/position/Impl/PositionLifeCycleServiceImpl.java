package hashwork.services.ui.position.Impl;

import hashwork.domain.ui.position.PositionLifeCycle;
import hashwork.repository.ui.positions.Impl.PositionLifeCycleRepositoryImpl;
import hashwork.services.ui.position.PositionLifeCycleService;

import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionLifeCycleServiceImpl implements PositionLifeCycleService {


    @Override
    public PositionLifeCycle findById(String id) {
        return new PositionLifeCycleRepositoryImpl().findById(id);
    }

    @Override
    public PositionLifeCycle save(PositionLifeCycle entity) {
        return new PositionLifeCycleRepositoryImpl().save(entity);
    }

    @Override
    public PositionLifeCycle update(PositionLifeCycle entity) {
        return new PositionLifeCycleRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PositionLifeCycle entity) {
        new PositionLifeCycleRepositoryImpl().delete(entity);

    }

    @Override
    public Set<PositionLifeCycle> findAll() {
        return new PositionLifeCycleRepositoryImpl().findAll();
    }

}
