package hashwork.repository.ui.utililties.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.util.DisciplineActionTypeList;
import hashwork.repository.ui.utililties.DisciplineActionTypeListRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class DisciplineActionTypeListRepositoryImpl implements DisciplineActionTypeListRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, DisciplineActionTypeList> lists = redisson.getMap("disciplineActionTypeList");

    @Override
    public DisciplineActionTypeList findById(String s) {
        return lists.get(s);
    }

    @Override
    public DisciplineActionTypeList save(DisciplineActionTypeList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public DisciplineActionTypeList update(DisciplineActionTypeList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(DisciplineActionTypeList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<DisciplineActionTypeList> findAll() {
        Set<DisciplineActionTypeList> set = new HashSet<>();
        for (Map.Entry<String, DisciplineActionTypeList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
