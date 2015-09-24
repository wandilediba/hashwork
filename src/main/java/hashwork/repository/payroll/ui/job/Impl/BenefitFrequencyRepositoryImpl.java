package hashwork.repository.payroll.ui.job.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.job.BenefitFrequency;
import hashwork.repository.payroll.ui.job.BenefitFrequencyRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/12.
 */
public class BenefitFrequencyRepositoryImpl implements BenefitFrequencyRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, BenefitFrequency> lists = redisson.getMap("BenefitFrequency");

    @Override
    public BenefitFrequency findById(String s) {
        return lists.get(s);
    }

    @Override
    public BenefitFrequency save(BenefitFrequency entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public BenefitFrequency update(BenefitFrequency entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(BenefitFrequency entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<BenefitFrequency> findAll() {
        Set<BenefitFrequency> set = new HashSet<>();
        for (Map.Entry<String, BenefitFrequency> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
