package hashwork.repository.ui.employee.Impl;

import hashwork.domain.ui.employee.Name;
import hashwork.repository.ui.employee.NameRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class NameRepositoryImpl implements NameRepository {
    Map<String, Name> lists = new HashMap<>();

    @Override
    public Name findById(String s) {
        return lists.get(s);
    }

    @Override
    public Name save(Name entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Name update(Name entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Name entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Name> findAll() {
        Set<Name> set = new HashSet<>();
        for (Map.Entry<String, Name> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}