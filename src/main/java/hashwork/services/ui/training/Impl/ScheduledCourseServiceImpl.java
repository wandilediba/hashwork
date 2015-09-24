package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.ScheduledCourse;
import hashwork.repository.ui.training.Impl.ScheduledCourseRepositoryImpl;
import hashwork.services.ui.training.ScheduledCourseService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class ScheduledCourseServiceImpl implements ScheduledCourseService {

    @Override
    public ScheduledCourse findById(String id) {
        return new ScheduledCourseRepositoryImpl().findById(id);
    }

    @Override
    public ScheduledCourse save(ScheduledCourse entity) {
        return new ScheduledCourseRepositoryImpl().save(entity);
    }

    @Override
    public ScheduledCourse update(ScheduledCourse entity) {
        return new ScheduledCourseRepositoryImpl().update(entity);
    }

    @Override
    public void delete(ScheduledCourse entity) {
        new ScheduledCourseRepositoryImpl().delete(entity);

    }

    @Override
    public Set<ScheduledCourse> findAll() {
        return new ScheduledCourseRepositoryImpl().findAll();
    }
}
