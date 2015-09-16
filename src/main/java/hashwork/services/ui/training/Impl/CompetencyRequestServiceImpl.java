package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.CompetencyRequest;
import hashwork.repository.ui.training.Impl.CompetencyRequestRepositoryImpl;
import hashwork.services.ui.training.CompetencyRequestService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class CompetencyRequestServiceImpl implements CompetencyRequestService {

    @Override
    public CompetencyRequest findById(String id) {
        return new CompetencyRequestRepositoryImpl().findById(id);
    }

    @Override
    public CompetencyRequest save(CompetencyRequest entity) {
        return new CompetencyRequestRepositoryImpl().save(entity);
    }

    @Override
    public CompetencyRequest update(CompetencyRequest entity) {
        return new CompetencyRequestRepositoryImpl().update(entity);
    }

    @Override
    public void delete(CompetencyRequest entity) {
        new CompetencyRequestRepositoryImpl().delete(entity);

    }

    @Override
    public Set<CompetencyRequest> findAll() {
        return new CompetencyRequestRepositoryImpl().findAll();
    }
}
