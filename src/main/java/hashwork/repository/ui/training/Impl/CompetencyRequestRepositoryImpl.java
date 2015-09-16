package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.CompetencyRequest;
import hashwork.repository.ui.training.CompetencyRequestRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class CompetencyRequestRepositoryImpl implements CompetencyRequestRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, CompetencyRequest> lists = redisson.getMap("addresstype");

    @Override
    public CompetencyRequest findById(String s) {
        return lists.get(s);
    }

    @Override
    public CompetencyRequest save(CompetencyRequest entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public CompetencyRequest update(CompetencyRequest entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(CompetencyRequest entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<CompetencyRequest> findAll() {
        Set<CompetencyRequest> set = new HashSet<>();
        for (Map.Entry<String, CompetencyRequest> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
