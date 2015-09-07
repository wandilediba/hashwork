package hashwork.repository.ui.employee.Impl;

import hashwork.domain.ui.employee.HireDate;
import hashwork.repository.ui.employee.HireDateRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class HireDateRepositoryImpl implements HireDateRepository {
    Map<String, HireDate> lists = new HashMap<>();

    @Override
    public HireDate findById(String s) {
        return lists.get(s);
    }

    @Override
    public HireDate save(HireDate entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public HireDate update(HireDate entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(HireDate entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<HireDate> findAll() {
        Set<HireDate> set = new HashSet<>();
        for (Map.Entry<String, HireDate> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}