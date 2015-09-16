package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.Course;
import hashwork.repository.ui.training.Impl.CourseRepositoryImpl;
import hashwork.services.ui.training.CourseService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class CourseServiceImpl implements CourseService {

    @Override
    public Course findById(String id) {
        return new CourseRepositoryImpl().findById(id);
    }

    @Override
    public Course save(Course entity) {
        return new CourseRepositoryImpl().save(entity);
    }

    @Override
    public Course update(Course entity) {
        return new CourseRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Course entity) {
        new CourseRepositoryImpl().delete(entity);

    }

    @Override
    public Set<Course> findAll() {
        return new CourseRepositoryImpl().findAll();
    }
}
