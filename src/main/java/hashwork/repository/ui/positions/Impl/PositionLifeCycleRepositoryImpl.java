package hashwork.repository.ui.positions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.position.PositionLifeCycle;
import hashwork.repository.ui.positions.PositionLifeCycleRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionLifeCycleRepositoryImpl implements PositionLifeCycleRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, PositionLifeCycle> lists = redisson.getMap("addresstype");

    @Override
    public PositionLifeCycle findById(String s) {
        return lists.get(s);
    }

    @Override
    public PositionLifeCycle save(PositionLifeCycle entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PositionLifeCycle update(PositionLifeCycle entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PositionLifeCycle entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PositionLifeCycle> findAll() {
        Set<PositionLifeCycle> set = new HashSet<>();
        for (Map.Entry<String, PositionLifeCycle> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
