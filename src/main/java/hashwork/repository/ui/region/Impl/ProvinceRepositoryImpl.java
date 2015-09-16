package hashwork.repository.ui.region.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.region.Province;
import hashwork.repository.ui.region.ProvinceRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class ProvinceRepositoryImpl implements ProvinceRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Province> lists = redisson.getMap("addresstype");

    @Override
    public Province findById(String s) {
        return lists.get(s);
    }

    @Override
    public Province save(Province entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Province update(Province entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Province entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Province> findAll() {
        Set<Province> set = new HashSet<>();
        for (Map.Entry<String, Province> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
