package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.ScheduledCourse;
import hashwork.repository.ui.training.Impl.ScheduledCourseRepositoryImpl;
import hashwork.services.ui.training.ScheduledCourseService;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public Set<ScheduledCourse> getApprovedScheduledCourse() {
        Set<ScheduledCourse> scheduledCourses = findAll()
                .parallelStream()
                .filter(scheduledCourse -> scheduledCourse.getStartDate().after(new Date()) & "APPROVED".equals(scheduledCourse.getStatus()))
                .collect(Collectors.toSet());
        return scheduledCourses;
    }
}
