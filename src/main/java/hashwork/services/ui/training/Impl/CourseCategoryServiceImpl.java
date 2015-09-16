package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.CourseCategory;
import hashwork.repository.ui.training.Impl.CourseCategoryRepositoryImpl;
import hashwork.services.ui.training.CourseCategoryService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Override
    public CourseCategory findById(String id) {
        return new CourseCategoryRepositoryImpl().findById(id);
    }

    @Override
    public CourseCategory save(CourseCategory entity) {
        return new CourseCategoryRepositoryImpl().save(entity);
    }

    @Override
    public CourseCategory update(CourseCategory entity) {
        return new CourseCategoryRepositoryImpl().update(entity);
    }

    @Override
    public void delete(CourseCategory entity) {
        new CourseCategoryRepositoryImpl().delete(entity);

    }

    @Override
    public Set<CourseCategory> findAll() {
        return new CourseCategoryRepositoryImpl().findAll();
    }
}
