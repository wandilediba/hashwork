package hashwork.repository.payroll.ui.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.PayrollTaxCalculations;
import hashwork.repository.payroll.ui.PayrollTaxCalculationsRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/09.
 */
public class PayrollTaxCalculationsRepositoryImpl implements PayrollTaxCalculationsRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, PayrollTaxCalculations> lists = redisson.getMap("payrolltaxCalc");

    public PayrollTaxCalculationsRepositoryImpl(){}
    @Override
    public PayrollTaxCalculations findById(String s) {
        return lists.get(s);
    }

    @Override
    public PayrollTaxCalculations save(PayrollTaxCalculations entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PayrollTaxCalculations update(PayrollTaxCalculations entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PayrollTaxCalculations entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PayrollTaxCalculations> findAll() {
        Set<PayrollTaxCalculations> set = new HashSet<>();
        for (Map.Entry<String, PayrollTaxCalculations> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
