package hashwork.repository.payroll.ui.deductions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.deductions.MedicalAidList;
import hashwork.repository.payroll.ui.deductions.MedicalAidListRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/09.
 */
public class MedicalAidListRepositoryImpl implements MedicalAidListRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, MedicalAidList> lists = redisson.getMap("MedAidList");

    public MedicalAidListRepositoryImpl() {

    }

    @Override
    public MedicalAidList findById(String s) {
        return lists.get(s);
    }

    @Override
    public MedicalAidList save(MedicalAidList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public MedicalAidList update(MedicalAidList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(MedicalAidList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<MedicalAidList> findAll() {
        Set<MedicalAidList> set = new HashSet<>();
        for (Map.Entry<String, MedicalAidList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
