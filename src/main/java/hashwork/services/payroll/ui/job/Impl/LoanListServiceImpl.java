package hashwork.services.payroll.ui.job.Impl;

import hashwork.domain.payroll.ui.LoansList;
import hashwork.repository.payroll.ui.job.Impl.LoanListRepositoryImpl;
import hashwork.repository.payroll.ui.job.LoanListRepository;
import hashwork.services.payroll.ui.job.LoanListService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/08.
 */
public class LoanListServiceImpl implements LoanListService {
    private final LoanListRepository repo = new LoanListRepositoryImpl();

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
