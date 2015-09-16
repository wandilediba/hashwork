package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.CourseRequest;
import hashwork.repository.ui.training.CourseRequestRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseRequestRepositoryImpl implements CourseRequestRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, CourseRequest> lists = redisson.getMap("addresstype");

    @Override
    public CourseRequest findById(String s) {
        return lists.get(s);
    }

    @Override
    public CourseRequest save(CourseRequest entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public CourseRequest update(CourseRequest entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(CourseRequest entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<CourseRequest> findAll() {
        Set<CourseRequest> set = new HashSet<>();
        for (Map.Entry<String, CourseRequest> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
