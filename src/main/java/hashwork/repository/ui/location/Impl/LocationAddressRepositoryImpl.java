package hashwork.repository.ui.location.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.location.LocationAddress;
import hashwork.repository.ui.location.LocationAddressRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationAddressRepositoryImpl implements LocationAddressRepository {

    Redisson redisson = Connection.getConnection();
    RMap<String, LocationAddress> lists = redisson.getMap("locationAddress");

    @Override
    public LocationAddress findById(String s) {
        return lists.get(s);
    }

    @Override
    public LocationAddress save(LocationAddress entity) {
        return lists.put(entity.getPostalAddress(), entity);
    }

    @Override
    public LocationAddress update(LocationAddress entity) {
        return lists.put(entity.getPostalAddress(), entity);
    }

    @Override
    public void delete(LocationAddress entity) {
        lists.remove(entity.getPostalAddress());
    }

    @Override
    public Set<LocationAddress> findAll() {
        Set<LocationAddress> set = new HashSet<>();
        for (Map.Entry<String, LocationAddress> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}