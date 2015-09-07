package hashwork.repository.ui.location.Impl;

import hashwork.domain.ui.location.Location;
import hashwork.repository.ui.location.LocationRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationRepositoryImpl implements LocationRepository {
    Map<String, Location> lists = new HashMap<>();

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