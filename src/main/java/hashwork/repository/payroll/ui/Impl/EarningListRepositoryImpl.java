package hashwork.repository.payroll.ui.Impl;

import hashwork.domain.payroll.ui.EarningsList;
import hashwork.repository.payroll.ui.EarningListRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/08.
 */
public class EarningListRepositoryImpl implements EarningListRepository {
    Map<String, EarningsList> lists = new HashMap<>();

    public EarningListRepositoryImpl(){}
    @Override
    public EarningsList findById(String s) {
        return lists.get(s);
    }

    @Override
    public EarningsList save(EarningsList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EarningsList update(EarningsList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EarningsList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<EarningsList> findAll() {
        Set<EarningsList> set = new HashSet<>();
        for (Map.Entry<String, EarningsList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
