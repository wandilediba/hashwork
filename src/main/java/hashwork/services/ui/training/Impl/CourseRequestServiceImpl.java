package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.CourseRequest;
import hashwork.repository.ui.training.Impl.CourseRequestRepositoryImpl;
import hashwork.services.ui.training.CourseRequestService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class CourseRequestServiceImpl implements CourseRequestService {

    @Override
    public CourseRequest findById(String id) {
        return new CourseRequestRepositoryImpl().findById(id);
    }

    @Override
    public CourseRequest save(CourseRequest entity) {
        return new CourseRequestRepositoryImpl().save(entity);
    }

    @Override
    public CourseRequest update(CourseRequest entity) {
        return new CourseRequestRepositoryImpl().update(entity);
    }

    @Override
    public void delete(CourseRequest entity) {
        new CourseRequestRepositoryImpl().delete(entity);

    }

    @Override
    public Set<CourseRequest> findAll() {
        return new CourseRequestRepositoryImpl().findAll();
    }
}
