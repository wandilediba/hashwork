package hashwork.repository.payroll.ui.deductions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.deductions.PensionFund;
import hashwork.repository.payroll.ui.deductions.PensionFundRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/09.
 */
public class PensionFundRepositoryImpl implements PensionFundRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, PensionFund> lists = redisson.getMap("pensionFund");

    public PensionFundRepositoryImpl() {

    }

    @Override
    public PensionFund findById(String s) {
        return lists.get(s);
    }

    @Override
    public PensionFund save(PensionFund entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PensionFund update(PensionFund entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PensionFund entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PensionFund> findAll() {
        Set<PensionFund> set = new HashSet<>();
        for (Map.Entry<String, PensionFund> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
