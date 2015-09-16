package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.ScheduledCourseEvaluation;
import hashwork.repository.ui.training.Impl.ScheduledCourseEvaluationRepositoryImpl;
import hashwork.services.ui.training.ScheduledCourseEvaluationService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class ScheduledCourseEvaluationServiceImpl implements ScheduledCourseEvaluationService {

    @Override
    public ScheduledCourseEvaluation findById(String id) {
        return new ScheduledCourseEvaluationRepositoryImpl().findById(id);
    }

    @Override
    public ScheduledCourseEvaluation save(ScheduledCourseEvaluation entity) {
        return new ScheduledCourseEvaluationRepositoryImpl().save(entity);
    }

    @Override
    public ScheduledCourseEvaluation update(ScheduledCourseEvaluation entity) {
        return new ScheduledCourseEvaluationRepositoryImpl().update(entity);
    }

    @Override
    public void delete(ScheduledCourseEvaluation entity) {
        new ScheduledCourseEvaluationRepositoryImpl().delete(entity);

    }

    @Override
    public Set<ScheduledCourseEvaluation> findAll() {
        return new ScheduledCourseEvaluationRepositoryImpl().findAll();
    }
}
