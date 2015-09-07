package hashwork.repository.ui.employee.Impl;

import hashwork.domain.ui.employee.EmployeeNumber;
import hashwork.repository.ui.employee.EmployeeNumberRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class EmployeeNumberRepositoryImpl implements EmployeeNumberRepository {
    Map<String, EmployeeNumber> lists = new HashMap<>();

    @Override
    public EmployeeNumber findById(String s) {
        return lists.get(s);
    }

    @Override
    public EmployeeNumber save(EmployeeNumber entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeeNumber update(EmployeeNumber entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeeNumber entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeeNumber> findAll() {
        Set<EmployeeNumber> set = new HashSet<>();
        for (Map.Entry<String, EmployeeNumber> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}