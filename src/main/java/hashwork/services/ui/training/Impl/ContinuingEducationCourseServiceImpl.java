package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.ContinuingEducationCourse;
import hashwork.repository.ui.training.Impl.ContinuingEducationCourseRespositoryImpl;
import hashwork.services.ui.training.ContinuingEducationCourseService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class ContinuingEducationCourseServiceImpl implements ContinuingEducationCourseService {

    @Override
    public ContinuingEducationCourse findById(String id) {
        return new ContinuingEducationCourseRespositoryImpl().findById(id);
    }

    @Override
    public ContinuingEducationCourse save(ContinuingEducationCourse entity) {
        return new ContinuingEducationCourseRespositoryImpl().save(entity);
    }

    @Override
    public ContinuingEducationCourse update(ContinuingEducationCourse entity) {
        return new ContinuingEducationCourseRespositoryImpl().update(entity);
    }

    @Override
    public void delete(ContinuingEducationCourse entity) {
        new ContinuingEducationCourseRespositoryImpl().delete(entity);

    }

    @Override
    public Set<ContinuingEducationCourse> findAll() {
        return new ContinuingEducationCourseRespositoryImpl().findAll();
    }
}
