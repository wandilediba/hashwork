package hashwork.repository.ui.employee.Impl;

import hashwork.domain.ui.employee.EmployeeType;
import hashwork.repository.ui.employee.EmployeeTypeRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class EmployeeTypeRepositoryImpl implements EmployeeTypeRepository {
    Map<String, EmployeeType> lists = new HashMap<>();

    @Override
    public EmployeeType findById(String s) {
        return lists.get(s);
    }

    @Override
    public EmployeeType save(EmployeeType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeeType update(EmployeeType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeeType entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeeType> findAll() {
        Set<EmployeeType> set = new HashSet<>();
        for (Map.Entry<String, EmployeeType> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}