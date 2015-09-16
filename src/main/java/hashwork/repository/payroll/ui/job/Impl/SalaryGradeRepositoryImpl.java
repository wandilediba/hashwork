package hashwork.repository.payroll.ui.job.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.job.SalaryGrade;
import hashwork.repository.payroll.ui.job.SalaryGradeRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/12.
 */
public class SalaryGradeRepositoryImpl implements SalaryGradeRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, SalaryGrade> lists = redisson.getMap("SalaryGrade");

    @Override
    public SalaryGrade findById(String s) {
        return lists.get(s);
    }

    @Override
    public SalaryGrade save(SalaryGrade entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public SalaryGrade update(SalaryGrade entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(SalaryGrade entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<SalaryGrade> findAll() {
        Set<SalaryGrade> set = new HashSet<>();
        for (Map.Entry<String, SalaryGrade> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
