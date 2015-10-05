package hashwork.services.payroll.ui.deductions.Impl;

import hashwork.domain.payroll.ui.deductions.LeaveTypeList;
import hashwork.repository.payroll.ui.deductions.LeaveTypeListRepository;
import hashwork.repository.payroll.ui.deductions.Impl.LeaveTypeListRepositoryImpl;
import hashwork.services.payroll.ui.deductions.LeaveTypeListService;

import java.util.Set;

/**
 *  Created by kurt on 15/09/13.
 */
public class LeaveTypeListServiceImpl implements LeaveTypeListService {
    private final LeaveTypeListRepositoryImpl repo = new LeaveTypeListRepositoryImpl();

    @Override
    public LeaveTypeList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public LeaveTypeList save(LeaveTypeList entity) {
        return repo.save(entity);
    }

    @Override
    public LeaveTypeList update(LeaveTypeList entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(LeaveTypeList entity) {
        repo.delete(entity);
    }

    @Override
    public Set<LeaveTypeList> findAll() {
        return repo.findAll();
    }
}
