package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.CompetencyRequestAggregate;
import hashwork.repository.ui.training.CompetencyRequestAggregateRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class CompetencyRequestAggregateRepositoryImpl implements CompetencyRequestAggregateRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, CompetencyRequestAggregate> lists = redisson.getMap("competencyRequestAggregate");

    @Override
    public CompetencyRequestAggregate findById(String s) {
        return lists.get(s);
    }

    @Override
    public CompetencyRequestAggregate save(CompetencyRequestAggregate entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public CompetencyRequestAggregate update(CompetencyRequestAggregate entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(CompetencyRequestAggregate entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<CompetencyRequestAggregate> findAll() {
        Set<CompetencyRequestAggregate> set = new HashSet<>();
        for (Map.Entry<String, CompetencyRequestAggregate> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
