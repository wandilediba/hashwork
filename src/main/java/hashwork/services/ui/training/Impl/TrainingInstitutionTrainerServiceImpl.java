package hashwork.services.ui.training.Impl;

import hashwork.domain.ui.training.TrainingInstitutionTrainer;
import hashwork.repository.ui.training.Impl.TrainingInstitutionTrainerRepositoryImpl;
import hashwork.services.ui.training.TrainingInstitutionTrainerService;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class TrainingInstitutionTrainerServiceImpl implements TrainingInstitutionTrainerService {

    @Override
    public TrainingInstitutionTrainer findById(String id) {
        return new TrainingInstitutionTrainerRepositoryImpl().findById(id);
    }

    @Override
    public TrainingInstitutionTrainer save(TrainingInstitutionTrainer entity) {
        return new TrainingInstitutionTrainerRepositoryImpl().save(entity);
    }

    @Override
    public TrainingInstitutionTrainer update(TrainingInstitutionTrainer entity) {
        return new TrainingInstitutionTrainerRepositoryImpl().update(entity);
    }

    @Override
    public void delete(TrainingInstitutionTrainer entity) {
        new TrainingInstitutionTrainerRepositoryImpl().delete(entity);

    }

    @Override
    public Set<TrainingInstitutionTrainer> findAll() {
        return new TrainingInstitutionTrainerRepositoryImpl().findAll();
    }
}
