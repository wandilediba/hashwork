package hashwork.repository.ui.location.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.location.AddressType;
import hashwork.repository.ui.location.AddressTypeRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class AddressTypeRepositoryImpl implements AddressTypeRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, AddressType> lists = redisson.getMap("addresstype");

    @Override
    public AddressType findById(String s) {
        return lists.get(s);
    }

    @Override
    public AddressType save(AddressType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public AddressType update(AddressType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(AddressType entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<AddressType> findAll() {
        Set<AddressType> set = new HashSet<>();
        for (Map.Entry<String, AddressType> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}