package hashwork.repository.payroll.ui.deductions.Impl;

import hashwork.domain.payroll.ui.deductions.LeaveTypeList;
import hashwork.repository.payroll.ui.deductions.LeaveTypeListRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/09.
 */
public class LeaveTypeListRepositoryImpl implements LeaveTypeListRepository {
    Map<String, LeaveTypeList> lists = new HashMap<>();

    public LeaveTypeListRepositoryImpl() {

    }

    @Override
    public LeaveTypeList findById(String s) {
        return lists.get(s);
    }

    @Override
    public LeaveTypeList save(LeaveTypeList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public LeaveTypeList update(LeaveTypeList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(LeaveTypeList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<LeaveTypeList> findAll() {
        Set<LeaveTypeList> set = new HashSet<>();
        for (Map.Entry<String, LeaveTypeList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
