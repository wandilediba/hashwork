package hashwork.repository.ui.positions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.position.Position;
import hashwork.repository.ui.positions.PositionRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionRepositoryImpl implements PositionRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Position> lists = redisson.getMap("addresstype");

    @Override
    public Position findById(String s) {
        return lists.get(s);
    }

    @Override
    public Position save(Position entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Position update(Position entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Position entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Position> findAll() {
        Set<Position> set = new HashSet<>();
        for (Map.Entry<String, Position> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
