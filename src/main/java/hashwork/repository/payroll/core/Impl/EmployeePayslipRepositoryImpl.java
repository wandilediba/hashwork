package hashwork.repository.payroll.core.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.core.EmployeePayslip;
import hashwork.repository.payroll.core.EmployeePayslipRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by nkosi on 2015/09/14.
 */

public class EmployeePayslipRepositoryImpl implements EmployeePayslipRepository{
    Redisson redisson = Connection.getConnection();
    RMap<String, EmployeePayslip> lists = redisson.getMap("EmployeePayslip");

    @Override
    public EmployeePayslip findById(String s) {
        return lists.get(s);
    }

    @Override
    public EmployeePayslip save(EmployeePayslip entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeePayslip update(EmployeePayslip entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeePayslip entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeePayslip> findAll() {
        Set<EmployeePayslip> set = new HashSet<>();
        for (Map.Entry<String, EmployeePayslip> entry : lists.entrySet()){
            set.add(entry.getValue());
        }
        return set;
    }
}
