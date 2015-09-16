package hashwork.repository.ui.positions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.position.DepartureReason;
import hashwork.repository.ui.positions.DepartureReasonRepsitory;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class DepartureReasonRepsitoryImpl implements DepartureReasonRepsitory {
    Redisson redisson = Connection.getConnection();
    RMap<String, DepartureReason> lists = redisson.getMap("addresstype");

    @Override
    public DepartureReason findById(String s) {
        return lists.get(s);
    }

    @Override
    public DepartureReason save(DepartureReason entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public DepartureReason update(DepartureReason entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(DepartureReason entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<DepartureReason> findAll() {
        Set<DepartureReason> set = new HashSet<>();
        for (Map.Entry<String, DepartureReason> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
