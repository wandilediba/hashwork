package hashwork.services.payroll.ui.job.Impl;

import hashwork.domain.payroll.ui.LoansList;
import hashwork.repository.payroll.ui.Impl.LoansListRepositoryImpl;
import hashwork.repository.payroll.ui.LoansListRepository;
import hashwork.services.payroll.ui.job.LoanListService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/08.
 */
public class LoanListServiceImpl implements LoanListService {
    private final LoansListRepository repo = new LoansListRepositoryImpl();

    @Override
    public LoansList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public LoansList save(LoansList entity) {
        return repo.save(entity);
    }

    @Override
    public LoansList update(LoansList entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(LoansList entity) {
        repo.delete(entity);
    }

    @Override
    public Set<LoansList> findAll() {
        return repo.findAll();
    }
}
