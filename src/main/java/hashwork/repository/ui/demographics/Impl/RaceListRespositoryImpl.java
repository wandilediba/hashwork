package hashwork.repository.ui.demographics.Impl;

import hashwork.domain.ui.demographics.RaceList;
import hashwork.repository.ui.demographics.RaceListRespository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hashcode on 2015/08/22.
 */
public class RaceListRespositoryImpl implements RaceListRespository {
    Map<String, RaceList> lists = new HashMap<>();

    @Override
    public RaceList findById(String s) {
        return lists.get(s);
    }

    @Override
    public RaceList save(RaceList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public RaceList update(RaceList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(RaceList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<RaceList> findAll() {
        Set<RaceList> set = new HashSet<>();
        for (Map.Entry<String, RaceList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
