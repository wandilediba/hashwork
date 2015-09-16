package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.CompetencyRequestAggregate;
import hashwork.repository.ui.training.Impl.CompetencyRequestAggregateRepositoryImpl;
import hashwork.services.ui.training.CompetencyRequestAggregateService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class CompetencyRequestAggregateServiceImpl implements CompetencyRequestAggregateService {

    @Override
    public CompetencyRequestAggregate findById(String id) {
        return new CompetencyRequestAggregateRepositoryImpl().findById(id);
    }

    @Override
    public CompetencyRequestAggregate save(CompetencyRequestAggregate entity) {
        return new CompetencyRequestAggregateRepositoryImpl().save(entity);
    }

    @Override
    public CompetencyRequestAggregate update(CompetencyRequestAggregate entity) {
        return new CompetencyRequestAggregateRepositoryImpl().update(entity);
    }

    @Override
    public void delete(CompetencyRequestAggregate entity) {
        new CompetencyRequestAggregateRepositoryImpl().delete(entity);

    }

    @Override
    public Set<CompetencyRequestAggregate> findAll() {
        return new CompetencyRequestAggregateRepositoryImpl().findAll();
    }
}
