package hashwork.repository.ui.demographics.Impl;

import hashwork.domain.ui.demographics.MaritalStatusList;
import hashwork.repository.ui.demographics.MaritalStatusListRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hashcode on 2015/08/22.
 */
public class MaritalStatusListRepositoryImpl implements MaritalStatusListRepository {
    Map<String, MaritalStatusList> lists = new HashMap<>();

    @Override
    public MaritalStatusList findById(String s) {
        return lists.get(s);
    }

    @Override
    public MaritalStatusList save(MaritalStatusList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public MaritalStatusList update(MaritalStatusList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(MaritalStatusList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<MaritalStatusList> findAll() {
        Set<MaritalStatusList> set = new HashSet<>();
        for (Map.Entry<String, MaritalStatusList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
