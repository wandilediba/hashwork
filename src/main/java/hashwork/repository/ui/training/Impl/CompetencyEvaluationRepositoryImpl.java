package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.CompetencyEvaluation;
import hashwork.repository.ui.training.CompetencyEvaluationRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class CompetencyEvaluationRepositoryImpl implements CompetencyEvaluationRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, CompetencyEvaluation> lists = redisson.getMap("addresstype");

    @Override
    public CompetencyEvaluation findById(String s) {
        return lists.get(s);
    }

    @Override
    public CompetencyEvaluation save(CompetencyEvaluation entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public CompetencyEvaluation update(CompetencyEvaluation entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(CompetencyEvaluation entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<CompetencyEvaluation> findAll() {
        Set<CompetencyEvaluation> set = new HashSet<>();
        for (Map.Entry<String, CompetencyEvaluation> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
