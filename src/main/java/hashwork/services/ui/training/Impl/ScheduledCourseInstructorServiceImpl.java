package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.ScheduledCourseInstructor;
import hashwork.repository.ui.training.Impl.ScheduledCourseInstructorRepositoryImpl;
import hashwork.services.ui.training.ScheduledCourseInstructorService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class ScheduledCourseInstructorServiceImpl implements ScheduledCourseInstructorService {

    @Override
    public ScheduledCourseInstructor findById(String id) {
        return new ScheduledCourseInstructorRepositoryImpl().findById(id);
    }

    @Override
    public ScheduledCourseInstructor save(ScheduledCourseInstructor entity) {
        return new ScheduledCourseInstructorRepositoryImpl().save(entity);
    }

    @Override
    public ScheduledCourseInstructor update(ScheduledCourseInstructor entity) {
        return new ScheduledCourseInstructorRepositoryImpl().update(entity);
    }

    @Override
    public void delete(ScheduledCourseInstructor entity) {
        new ScheduledCourseInstructorRepositoryImpl().delete(entity);

    }

    @Override
    public Set<ScheduledCourseInstructor> findAll() {
        return new ScheduledCourseInstructorRepositoryImpl().findAll();
    }
}
