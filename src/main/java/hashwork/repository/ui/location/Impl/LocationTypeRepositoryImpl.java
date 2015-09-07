package hashwork.repository.ui.location.Impl;

import hashwork.domain.ui.location.LocationType;
import hashwork.repository.ui.location.LocationTypeRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationTypeRepositoryImpl implements LocationTypeRepository {
    Map<String, LocationType> lists = new HashMap<>();

    @Override
    public LocationType findById(String s) {
        return lists.get(s);
    }

    @Override
    public LocationType save(LocationType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public LocationType update(LocationType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(LocationType entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<LocationType> findAll() {
        Set<LocationType> set = new HashSet<>();
        for (Map.Entry<String, LocationType> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}