package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.ScheduledCourseEvaluation;
import hashwork.repository.ui.training.ScheduledCourseEvaluationRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class ScheduledCourseEvaluationRepositoryImpl implements ScheduledCourseEvaluationRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, ScheduledCourseEvaluation> lists = redisson.getMap("scheduledCourseEvaluation");

    @Override
    public ScheduledCourseEvaluation findById(String s) {
        return lists.get(s);
    }

    @Override
    public ScheduledCourseEvaluation save(ScheduledCourseEvaluation entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public ScheduledCourseEvaluation update(ScheduledCourseEvaluation entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(ScheduledCourseEvaluation entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<ScheduledCourseEvaluation> findAll() {
        Set<ScheduledCourseEvaluation> set = new HashSet<>();
        for (Map.Entry<String, ScheduledCourseEvaluation> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
