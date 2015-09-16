package hashwork.repository.ui.demographics.Impl;

import hashwork.domain.ui.demographics.TitleList;
import hashwork.repository.ui.demographics.TitleListRespository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hashcode on 2015/08/22.
 */
public class TitleListRespositoryImpl implements TitleListRespository {
    Map<String, TitleList> lists = new HashMap<>();

    @Override
    public TitleList findById(String s) {
        return lists.get(s);
    }

    @Override
    public TitleList save(TitleList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public TitleList update(TitleList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(TitleList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<TitleList> findAll() {
        Set<TitleList> set = new HashSet<>();
        for (Map.Entry<String, TitleList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
