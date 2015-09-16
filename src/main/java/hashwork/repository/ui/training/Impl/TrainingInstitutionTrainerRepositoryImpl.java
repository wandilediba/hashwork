package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.TrainingInstitutionTrainer;
import hashwork.repository.ui.training.TrainingInstitutionTrainerRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class TrainingInstitutionTrainerRepositoryImpl implements TrainingInstitutionTrainerRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, TrainingInstitutionTrainer> lists = redisson.getMap("addresstype");

    @Override
    public TrainingInstitutionTrainer findById(String s) {
        return lists.get(s);
    }

    @Override
    public TrainingInstitutionTrainer save(TrainingInstitutionTrainer entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public TrainingInstitutionTrainer update(TrainingInstitutionTrainer entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(TrainingInstitutionTrainer entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<TrainingInstitutionTrainer> findAll() {
        Set<TrainingInstitutionTrainer> set = new HashSet<>();
        for (Map.Entry<String, TrainingInstitutionTrainer> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
