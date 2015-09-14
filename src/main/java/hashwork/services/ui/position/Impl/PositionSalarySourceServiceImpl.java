package hashwork.services.ui.position.Impl;

import hashwork.domain.ui.position.PositionSalarySource;
import hashwork.repository.ui.positions.Impl.PositionSalarySourceRepositoryImpl;
import hashwork.services.ui.position.PositionSalarySourceService;

import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionSalarySourceServiceImpl implements PositionSalarySourceService {


    @Override
    public PositionSalarySource findById(String id) {
        return new PositionSalarySourceRepositoryImpl().findById(id);
    }

    @Override
    public PositionSalarySource save(PositionSalarySource entity) {
        return new PositionSalarySourceRepositoryImpl().save(entity);
    }

    @Override
    public PositionSalarySource update(PositionSalarySource entity) {
        return new PositionSalarySourceRepositoryImpl().update(entity);
    }

    @Override
    public void delete(PositionSalarySource entity) {
        new PositionSalarySourceRepositoryImpl().delete(entity);

    }

    @Override
    public Set<PositionSalarySource> findAll() {
        return new PositionSalarySourceRepositoryImpl().findAll();
    }

}
