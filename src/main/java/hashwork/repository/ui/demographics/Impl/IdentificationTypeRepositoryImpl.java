package hashwork.repository.ui.demographics.Impl;

import hashwork.domain.ui.demographics.IdentificationType;
import hashwork.repository.ui.demographics.IdentificationTypeRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hashcode on 2015/08/22.
 */
public class IdentificationTypeRepositoryImpl implements IdentificationTypeRepository {
    Map<String, IdentificationType> lists = new HashMap<>();

    @Override
    public IdentificationType findById(String s) {
        return lists.get(s);
    }

    @Override
    public IdentificationType save(IdentificationType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public IdentificationType update(IdentificationType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(IdentificationType entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<IdentificationType> findAll() {
        Set<IdentificationType> set = new HashSet<>();
        for (Map.Entry<String, IdentificationType> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
