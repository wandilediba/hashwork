package hashwork.repository.payroll.ui.job.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.job.BenefitType;
import hashwork.repository.payroll.ui.job.BenefitTypeRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/12.
 */
public class BenefitTypeRepositoryImpl implements BenefitTypeRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, BenefitType> lists = redisson.getMap("BenefitType");

    @Override
    public BenefitType findById(String s) {
        return lists.get(s);
    }

    @Override
    public BenefitType save(BenefitType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public BenefitType update(BenefitType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(BenefitType entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<BenefitType> findAll() {
        Set<BenefitType> set = new HashSet<>();
        for (Map.Entry<String, BenefitType> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
