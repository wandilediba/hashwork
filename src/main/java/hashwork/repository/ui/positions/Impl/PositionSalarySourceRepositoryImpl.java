package hashwork.repository.ui.positions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.position.PositionSalarySource;
import hashwork.repository.ui.positions.PositionSalarySourceRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionSalarySourceRepositoryImpl implements PositionSalarySourceRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, PositionSalarySource> lists = redisson.getMap("addresstype");

    @Override
    public PositionSalarySource findById(String s) {
        return lists.get(s);
    }

    @Override
    public PositionSalarySource save(PositionSalarySource entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PositionSalarySource update(PositionSalarySource entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PositionSalarySource entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PositionSalarySource> findAll() {
        Set<PositionSalarySource> set = new HashSet<>();
        for (Map.Entry<String, PositionSalarySource> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
