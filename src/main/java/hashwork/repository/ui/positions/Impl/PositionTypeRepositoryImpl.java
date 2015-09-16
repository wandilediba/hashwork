package hashwork.repository.ui.positions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.position.PositionType;
import hashwork.repository.ui.positions.PositionTypeRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionTypeRepositoryImpl implements PositionTypeRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, PositionType> lists = redisson.getMap("addresstype");

    @Override
    public PositionType findById(String s) {
        return lists.get(s);
    }

    @Override
    public PositionType save(PositionType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PositionType update(PositionType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PositionType entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PositionType> findAll() {
        Set<PositionType> set = new HashSet<>();
        for (Map.Entry<String, PositionType> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}