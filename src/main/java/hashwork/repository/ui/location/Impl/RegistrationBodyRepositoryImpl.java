package hashwork.repository.ui.location.Impl;

import hashwork.domain.ui.location.RegistrationBody;
import hashwork.repository.ui.location.RegistrationBodyRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class RegistrationBodyRepositoryImpl implements RegistrationBodyRepository {
    Map<String, RegistrationBody> lists = new HashMap<>();

    @Override
    public RegistrationBody findById(String s) {
        return lists.get(s);
    }

    @Override
    public RegistrationBody save(RegistrationBody entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public RegistrationBody update(RegistrationBody entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(RegistrationBody entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<RegistrationBody> findAll() {
        Set<RegistrationBody> set = new HashSet<>();
        for (Map.Entry<String, RegistrationBody> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}