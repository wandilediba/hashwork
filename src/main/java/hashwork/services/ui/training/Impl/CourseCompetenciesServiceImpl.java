package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.CourseCompetencies;
import hashwork.repository.ui.training.Impl.CourseCompetenciesRepositoryImpl;
import hashwork.services.ui.training.CourseCompetenciesService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class CourseCompetenciesServiceImpl implements CourseCompetenciesService {

    @Override
    public CourseCompetencies findById(String id) {
        return new CourseCompetenciesRepositoryImpl().findById(id);
    }

    @Override
    public CourseCompetencies save(CourseCompetencies entity) {
        return new CourseCompetenciesRepositoryImpl().save(entity);
    }

    @Override
    public CourseCompetencies update(CourseCompetencies entity) {
        return new CourseCompetenciesRepositoryImpl().update(entity);
    }

    @Override
    public void delete(CourseCompetencies entity) {
        new CourseCompetenciesRepositoryImpl().delete(entity);

    }

    @Override
    public Set<CourseCompetencies> findAll() {
        return new CourseCompetenciesRepositoryImpl().findAll();
    }
}
