package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.TrainingInstitution;
import hashwork.repository.ui.training.TrainingInstitutionRepositpry;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class TrainingInstitutionRepositoryImpl implements TrainingInstitutionRepositpry {
    Redisson redisson = Connection.getConnection();
    RMap<String, TrainingInstitution> lists = redisson.getMap("addresstype");

    @Override
    public TrainingInstitution findById(String s) {
        return lists.get(s);
    }

    @Override
    public TrainingInstitution save(TrainingInstitution entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public TrainingInstitution update(TrainingInstitution entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(TrainingInstitution entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<TrainingInstitution> findAll() {
        Set<TrainingInstitution> set = new HashSet<>();
        for (Map.Entry<String, TrainingInstitution> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
