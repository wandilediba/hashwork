package hashwork.repository.payroll.ui.deductions.Impl;

import hashwork.domain.payroll.ui.deductions.MedicalAidList;
import hashwork.repository.payroll.ui.deductions.MedicalAidListRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/09.
 */
public class MedicalAidListRepositoryImpl implements MedicalAidListRepository {
    Map<String, MedicalAidList> lists = new HashMap<>();

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
