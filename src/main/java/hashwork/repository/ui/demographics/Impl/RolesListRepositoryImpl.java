package hashwork.repository.ui.demographics.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.demographics.RolesList;
import hashwork.repository.ui.demographics.RolesListRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hashcode on 2015/08/22.
 */
public class RolesListRepositoryImpl implements RolesListRepository {
    Redisson redisson = Connection.getCinnection();
    RMap<String, RolesList> rolelist = redisson.getMap("rolelist");

    @Override
    public RolesList findById(String s) {
        return rolelist.get(s);
    }

    @Override
    public RolesList save(RolesList entity) {
        rolelist.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public RolesList update(RolesList entity) {
        rolelist.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void delete(RolesList entity) {
        rolelist.remove(entity.getId());
    }

    @Override
    public Set<RolesList> findAll() {
        Set<RolesList> set = new HashSet<>();
        for (Map.Entry<String, RolesList> entry : rolelist.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
