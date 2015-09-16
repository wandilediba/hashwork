package hashwork.repository.payroll.ui.deductions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.deductions.AllowanceTypeList;
import hashwork.repository.payroll.ui.deductions.AllowanceTypeListRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/08.
 */
public class AllowanceTypeListRepositoryImpl implements AllowanceTypeListRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, AllowanceTypeList> lists = redisson.getMap("allowanceTypeList");

    public AllowanceTypeListRepositoryImpl() {

    }

    @Override
    public AllowanceTypeList findById(String s) {
        return lists.get(s);
    }

    @Override
    public AllowanceTypeList save(AllowanceTypeList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public AllowanceTypeList update(AllowanceTypeList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(AllowanceTypeList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<AllowanceTypeList> findAll() {
        Set<AllowanceTypeList> set = new HashSet<>();
        for (Map.Entry<String, AllowanceTypeList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
