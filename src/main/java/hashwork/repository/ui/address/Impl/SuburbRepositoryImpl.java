package hashwork.repository.ui.address.Impl;

import hashwork.domain.ui.address.Suburb;
import hashwork.repository.ui.address.SuburbRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/08/30.
 */


public class SuburbRepositoryImpl implements SuburbRepository {
    Map<String, Suburb> lists = new HashMap<>();

    @Override
    public Suburb findById(String s) {
        return lists.get(s);
    }

    @Override
    public Suburb save(Suburb entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Suburb update(Suburb entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Suburb entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Suburb> findAll() {
        Set<Suburb> set = new HashSet<>();
        for (Map.Entry<String, Suburb> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}