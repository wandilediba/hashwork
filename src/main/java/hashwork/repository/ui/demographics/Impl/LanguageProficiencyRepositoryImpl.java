package hashwork.repository.ui.demographics.Impl;

import hashwork.domain.ui.demographics.LanguageProficiency;
import hashwork.repository.ui.demographics.LanguageProficiencyRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hashcode on 2015/08/22.
 */
public class LanguageProficiencyRepositoryImpl implements LanguageProficiencyRepository {
    Map<String, LanguageProficiency> lists = new HashMap<>();

    @Override
    public LanguageProficiency findById(String s) {
        return lists.get(s);
    }

    @Override
    public LanguageProficiency save(LanguageProficiency entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public LanguageProficiency update(LanguageProficiency entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(LanguageProficiency entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<LanguageProficiency> findAll() {
        Set<LanguageProficiency> set = new HashSet<>();
        for (Map.Entry<String, LanguageProficiency> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
