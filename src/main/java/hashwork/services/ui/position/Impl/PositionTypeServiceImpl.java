package hashwork.services.ui.position.Impl;

import hashwork.domain.ui.position.PositionType;
import hashwork.repository.ui.positions.Impl.PositionTypeRepositoryImpl;
import hashwork.services.ui.position.PositionTypeService;

import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionTypeServiceImpl implements PositionTypeService {


    @Override
    public PositionType findById(String id) {
        return new PositionTypeRepositoryImpl().findById(id);
    }

    @Override
    public PositionType save(PositionType entity) {
        return new PositionTypeRepositoryImpl().save(entity);
    }

    @Override
    public PositionType update(PositionType entity) {
        return new PositionTypeRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PositionType entity) {
        new PositionTypeRepositoryImpl().delete(entity);

    }

    @Override
    public Set<PositionType> findAll() {
        return new PositionTypeRepositoryImpl().findAll();
    }

}
