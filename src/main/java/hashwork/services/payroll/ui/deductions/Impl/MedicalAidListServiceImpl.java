package hashwork.services.payroll.ui.deductions.Impl;

import hashwork.domain.payroll.ui.deductions.MedicalAidList;
import hashwork.repository.payroll.ui.deductions.MedicalAidListRepository;
import hashwork.repository.payroll.ui.deductions.Impl.MedicalAidListRepositoryImpl;
import hashwork.services.payroll.ui.deductions.MedicalAidListService;

import java.util.Set;

/**
 *  Created by kurt on 15/09/13.
 */
public class MedicalAidListServiceImpl implements MedicalAidListService {
    private final MedicalAidListRepositoryImpl repo = new MedicalAidListRepositoryImpl();

    @Override
    public MedicalAidList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public MedicalAidList save(MedicalAidList entity) {
        return repo.save(entity);
    }

    @Override
    public MedicalAidList update(MedicalAidList entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(MedicalAidList entity) {
        repo.delete(entity);
    }

    @Override
    public Set<MedicalAidList> findAll() {
        return repo.findAll();
    }
}
