package hashwork.repository.ui.demographics.Impl;

import hashwork.domain.ui.demographics.RolesList;
import hashwork.repository.ui.demographics.RolesListRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hashcode on 2015/08/22.
 */
public class RolesListRepositoryImpl implements RolesListRepository {
    Map<String, RolesList> lists = new HashMap<>();

    @Override
    public RolesList findById(String s) {
        return lists.get(s);
    }

    @Override
    public RolesList save(RolesList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public RolesList update(RolesList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(RolesList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<RolesList> findAll() {
        Set<RolesList> set = new HashSet<>();
        for (Map.Entry<String, RolesList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
