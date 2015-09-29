package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.CourseCompetencies;
import hashwork.repository.ui.training.CourseCompetenciesRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseCompetenciesRepositoryImpl implements CourseCompetenciesRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, CourseCompetencies> lists = redisson.getMap("courseCompetencies");

    @Override
    public CourseCompetencies findById(String s) {
        return lists.get(s);
    }

    @Override
    public CourseCompetencies save(CourseCompetencies entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public CourseCompetencies update(CourseCompetencies entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(CourseCompetencies entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<CourseCompetencies> findAll() {
        Set<CourseCompetencies> set = new HashSet<>();
        for (Map.Entry<String, CourseCompetencies> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
