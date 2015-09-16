package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.TrainingInstitution;
import hashwork.repository.ui.training.Impl.TrainingInstitutionRepositoryImpl;
import hashwork.services.ui.training.TrainingInstitutionService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class TrainingInstitutionServiceImpl implements TrainingInstitutionService {

    @Override
    public TrainingInstitution findById(String id) {
        return new TrainingInstitutionRepositoryImpl().findById(id);
    }

    @Override
    public TrainingInstitution save(TrainingInstitution entity) {
        return new TrainingInstitutionRepositoryImpl().save(entity);
    }

    @Override
    public TrainingInstitution update(TrainingInstitution entity) {
        return new TrainingInstitutionRepositoryImpl().update(entity);
    }

    @Override
    public void delete(TrainingInstitution entity) {
        new TrainingInstitutionRepositoryImpl().delete(entity);

    }

    @Override
    public Set<TrainingInstitution> findAll() {
        return new TrainingInstitutionRepositoryImpl().findAll();
    }
}
