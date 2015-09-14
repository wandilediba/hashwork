package hashwork.repository.ui.utililties.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.util.Funder;
import hashwork.repository.ui.utililties.FunderRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class FunderRepositoryImpl implements FunderRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Funder> lists = redisson.getMap("addresstype");

    @Override
    public Funder findById(String s) {
        return lists.get(s);
    }

    @Override
    public Funder save(Funder entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Funder update(Funder entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Funder entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Funder> findAll() {
        Set<Funder> set = new HashSet<>();
        for (Map.Entry<String, Funder> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
