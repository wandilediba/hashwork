package hashwork.repository.ui.employee.Impl;

import hashwork.domain.ui.employee.Surname;
import hashwork.repository.ui.employee.SurnameRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class SurnameRepositoryImpl implements SurnameRepository {
    Map<String, Surname> lists = new HashMap<>();

    @Override
    public Surname findById(String s) {
        return lists.get(s);
    }

    @Override
    public Surname save(Surname entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Surname update(Surname entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Surname entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Surname> findAll() {
        Set<Surname> set = new HashSet<>();
        for (Map.Entry<String, Surname> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}