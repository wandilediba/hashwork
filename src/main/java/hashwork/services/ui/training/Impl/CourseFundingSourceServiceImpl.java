package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.CourseFundingSource;
import hashwork.repository.ui.training.Impl.CourseFundingSourceRepositoryImpl;
import hashwork.services.ui.training.CourseFundingSourceService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class CourseFundingSourceServiceImpl implements CourseFundingSourceService {

    @Override
    public CourseFundingSource findById(String id) {
        return new CourseFundingSourceRepositoryImpl().findById(id);
    }

    @Override
    public CourseFundingSource save(CourseFundingSource entity) {
        return new CourseFundingSourceRepositoryImpl().save(entity);
    }

    @Override
    public CourseFundingSource update(CourseFundingSource entity) {
        return new CourseFundingSourceRepositoryImpl().update(entity);
    }

    @Override
    public void delete(CourseFundingSource entity) {
        new CourseFundingSourceRepositoryImpl().delete(entity);

    }

    @Override
    public Set<CourseFundingSource> findAll() {
        return new CourseFundingSourceRepositoryImpl().findAll();
    }
}
