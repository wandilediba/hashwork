package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.CompetencyEvaluation;
import hashwork.repository.ui.training.Impl.CompetencyEvaluationRepositoryImpl;
import hashwork.services.ui.training.CompetencyEvaluationService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class CompetencyEvaluationServiceImpl implements CompetencyEvaluationService {

    @Override
    public CompetencyEvaluation findById(String id) {
        return new CompetencyEvaluationRepositoryImpl().findById(id);
    }

    @Override
    public CompetencyEvaluation save(CompetencyEvaluation entity) {
        return new CompetencyEvaluationRepositoryImpl().save(entity);
    }

    @Override
    public CompetencyEvaluation update(CompetencyEvaluation entity) {
        return new CompetencyEvaluationRepositoryImpl().update(entity);
    }

    @Override
    public void delete(CompetencyEvaluation entity) {
        new CompetencyEvaluationRepositoryImpl().delete(entity);
    }

    @Override
    public Set<CompetencyEvaluation> findAll() {
        return new CompetencyEvaluationRepositoryImpl().findAll();
    }
}
