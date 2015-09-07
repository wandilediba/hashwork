package hashwork.repository.ui.employee.Impl;

import hashwork.domain.ui.employee.IdentificationNumber;
import hashwork.repository.ui.employee.IdentificationNumberRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */

public class IdentificationNumberRepositoryImpl implements IdentificationNumberRepository {
    Map<String, IdentificationNumber> lists = new HashMap<>();

    @Override
    public IdentificationNumber findById(String s) {
        return lists.get(s);
    }

    @Override
    public IdentificationNumber save(IdentificationNumber entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public IdentificationNumber update(IdentificationNumber entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(IdentificationNumber entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<IdentificationNumber> findAll() {
        Set<IdentificationNumber> set = new HashSet<>();
        for (Map.Entry<String, IdentificationNumber> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}