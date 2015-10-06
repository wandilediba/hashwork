package hashwork.repository.payroll.ui.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.LoansList;
import hashwork.repository.payroll.ui.LoansListRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/09.
 */
public class LoansListRepositoryImpl implements LoansListRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, LoansList> lists = redisson.getMap("LoansList");

    public LoansListRepositoryImpl(){}
    @Override
    public LoansList findById(String s) {
        return lists.get(s);
    }

    @Override
    public LoansList save(LoansList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public LoansList update(LoansList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(LoansList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<LoansList> findAll() {
        Set<LoansList> set = new HashSet<>();
        for (Map.Entry<String, LoansList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
