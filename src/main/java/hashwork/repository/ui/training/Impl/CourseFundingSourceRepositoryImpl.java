package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.CourseFundingSource;
import hashwork.repository.ui.training.CourseFundingSourceRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseFundingSourceRepositoryImpl implements CourseFundingSourceRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, CourseFundingSource> lists = redisson.getMap("addresstype");

    @Override
    public CourseFundingSource findById(String s) {
        return lists.get(s);
    }

    @Override
    public CourseFundingSource save(CourseFundingSource entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public CourseFundingSource update(CourseFundingSource entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(CourseFundingSource entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<CourseFundingSource> findAll() {
        Set<CourseFundingSource> set = new HashSet<>();
        for (Map.Entry<String, CourseFundingSource> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
