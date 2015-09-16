package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.ContinuingEducationCourse;
import hashwork.repository.ui.training.ContinuingEducationCourseRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class ContinuingEducationCourseRespositoryImpl implements ContinuingEducationCourseRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, ContinuingEducationCourse> lists = redisson.getMap("addresstype");

    @Override
    public ContinuingEducationCourse findById(String s) {
        return lists.get(s);
    }

    @Override
    public ContinuingEducationCourse save(ContinuingEducationCourse entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public ContinuingEducationCourse update(ContinuingEducationCourse entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(ContinuingEducationCourse entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<ContinuingEducationCourse> findAll() {
        Set<ContinuingEducationCourse> set = new HashSet<>();
        for (Map.Entry<String, ContinuingEducationCourse> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
