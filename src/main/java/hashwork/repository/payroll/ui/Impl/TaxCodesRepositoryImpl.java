package hashwork.repository.payroll.ui.Impl;

import hashwork.domain.payroll.ui.TaxCodes;
import hashwork.repository.payroll.ui.TaxCodesRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/09.
 */
public class TaxCodesRepositoryImpl implements TaxCodesRepository {
    Map<String, TaxCodes> lists = new HashMap<>();

    public TaxCodesRepositoryImpl(){}
    @Override
    public TaxCodes findById(String s) {
        return lists.get(s);
    }

    @Override
    public TaxCodes save(TaxCodes entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public TaxCodes update(TaxCodes entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(TaxCodes entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<TaxCodes> findAll() {
        Set<TaxCodes> set = new HashSet<>();
        for (Map.Entry<String, TaxCodes> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
