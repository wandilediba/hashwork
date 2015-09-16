package hashwork.repository.ui.demographics.Impl;

import hashwork.domain.ui.demographics.GenderList;
import hashwork.repository.ui.demographics.GenderListRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hashcode on 2015/08/22.
 */
public class GenderListRepositoryImpl implements GenderListRepository {
    Map<String, GenderList> lists = new HashMap<>();

    public GenderListRepositoryImpl() {

    }

    @Override
    public GenderList findById(String s) {
        return lists.get(s);
    }

    @Override
    public GenderList save(GenderList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public GenderList update(GenderList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(GenderList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<GenderList> findAll() {
        Set<GenderList> set = new HashSet<>();
        for (Map.Entry<String, GenderList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
