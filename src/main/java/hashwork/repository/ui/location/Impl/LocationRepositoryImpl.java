package hashwork.repository.ui.location.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.location.Location;
import hashwork.repository.ui.location.LocationRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationRepositoryImpl implements LocationRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Location> lists = redisson.getMap("location");

    @Override
    public Location findById(String s) {
        return lists.get(s);
    }

    @Override
    public Location save(Location entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Location update(Location entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Location entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Location> findAll() {
        Set<Location> set = new HashSet<>();
        for (Map.Entry<String, Location> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}