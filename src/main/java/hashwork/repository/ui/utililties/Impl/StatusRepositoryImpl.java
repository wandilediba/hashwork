package hashwork.repository.ui.utililties.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.util.Status;
import hashwork.repository.ui.utililties.StatusRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class StatusRepositoryImpl implements StatusRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Status> lists = redisson.getMap("addresstype");

    @Override
    public Status findById(String s) {
        return lists.get(s);
    }

    @Override
    public Status save(Status entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Status update(Status entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Status entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Status> findAll() {
        Set<Status> set = new HashSet<>();
        for (Map.Entry<String, Status> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
