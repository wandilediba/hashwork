package hashwork.repository.ui.utililties.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.util.AccidentTypeList;
import hashwork.repository.ui.utililties.AccidentTypeListRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class AccidentTypeListRepositoryImpl implements AccidentTypeListRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, AccidentTypeList> lists = redisson.getMap("addresstype");

    @Override
    public AccidentTypeList findById(String s) {
        return lists.get(s);
    }

    @Override
    public AccidentTypeList save(AccidentTypeList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public AccidentTypeList update(AccidentTypeList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(AccidentTypeList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<AccidentTypeList> findAll() {
        Set<AccidentTypeList> set = new HashSet<>();
        for (Map.Entry<String, AccidentTypeList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
