package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.ScheduledCourseRequestor;
import hashwork.repository.ui.training.Impl.ScheduledCourseRequestorRepositoryImpl;
import hashwork.services.ui.training.ScheduledCourseRequestorService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class ScheduledCourseRequestorServiceImpl implements ScheduledCourseRequestorService {

    @Override
    public ScheduledCourseRequestor findById(String id) {
        return new ScheduledCourseRequestorRepositoryImpl().findById(id);
    }

    @Override
    public ScheduledCourseRequestor save(ScheduledCourseRequestor entity) {
        return new ScheduledCourseRequestorRepositoryImpl().save(entity);
    }

    @Override
    public ScheduledCourseRequestor update(ScheduledCourseRequestor entity) {
        return new ScheduledCourseRequestorRepositoryImpl().update(entity);
    }

    @Override
    public void delete(ScheduledCourseRequestor entity) {
        new ScheduledCourseRequestorRepositoryImpl().delete(entity);

    }

    @Override
    public Set<ScheduledCourseRequestor> findAll() {
        return new ScheduledCourseRequestorRepositoryImpl().findAll();
    }
}
