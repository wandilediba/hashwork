package hashwork.services.ui.position.Impl;

import hashwork.domain.ui.position.Position;
import hashwork.repository.ui.positions.Impl.PositionRepositoryImpl;
import hashwork.services.ui.position.PositionService;

import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionServiceImpl implements PositionService {


    @Override
    public Position findById(String id) {
        return new PositionRepositoryImpl().findById(id);
    }

    @Override
    public Position save(Position entity) {
        return new PositionRepositoryImpl().save(entity);
    }

    @Override
    public Position update(Position entity) {
        return new PositionRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Position entity) {
        new PositionRepositoryImpl().delete(entity);

    }

    @Override
    public Set<Position> findAll() {
        return new PositionRepositoryImpl().findAll();
    }

}
