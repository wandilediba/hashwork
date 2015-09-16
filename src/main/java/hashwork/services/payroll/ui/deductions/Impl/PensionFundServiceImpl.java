package hashwork.services.payroll.ui.deductions.Impl;

import hashwork.domain.payroll.ui.deductions.PensionFund;
import hashwork.repository.payroll.ui.deductions.PensionFundRepository;
import hashwork.repository.payroll.ui.deductions.Impl.PensionFundRepositoryImpl;
import hashwork.services.payroll.ui.deductions.PensionFundService;

import java.util.Set;

/**
 *  Created by kurt on 15/09/13.
 */
public class PensionFundServiceImpl implements PensionFundService {
    private final PensionFundRepositoryImpl repo = new PensionFundRepositoryImpl();

    @Override
    public PensionFund findById(String s) {
        return repo.findById(s);
    }

    @Override
    public PensionFund save(PensionFund entity) {
        return repo.save(entity);
    }

    @Override
    public PensionFund update(PensionFund entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(PensionFund entity) {
        repo.delete(entity);
    }

    @Override
    public Set<PensionFund> findAll() {
        return repo.findAll();
    }
}
