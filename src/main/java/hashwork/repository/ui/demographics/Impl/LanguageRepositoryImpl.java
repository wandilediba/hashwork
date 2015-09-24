package hashwork.repository.ui.demographics.Impl;

import hashwork.domain.ui.demographics.Language;
import hashwork.repository.ui.demographics.LanguageRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hashcode on 2015/08/22.
 */
public class LanguageRepositoryImpl implements LanguageRepository {
    Map<String, Language> lists = new HashMap<>();

    @Override
    public Language findById(String s) {
        return lists.get(s);
    }

    @Override
    public Language save(Language entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Language update(Language entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Language entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Language> findAll() {
        Set<Language> set = new HashSet<>();
        for (Map.Entry<String, Language> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
