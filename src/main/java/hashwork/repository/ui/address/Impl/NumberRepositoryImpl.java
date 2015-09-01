package hashwork.repository.ui.address.Impl;

import hashwork.repository.ui.address.NumberRepository;
import hashwork.domain.ui.address.Number;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/08/30.
 */
public class NumberRepositoryImpl implements NumberRepository {
    Map<String, Number> lists = new HashMap<>();

    @Override
    public Number findById(String s) {
        return lists.get(s);
    }

    @Override
    public Number save(Number entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Number update(Number entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Number entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Number> findAll() {
        Set<Number> set = new HashSet<>();
        for (Map.Entry<String, Number> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}