package hashwork.services.payroll.ui.Impl;

import hashwork.domain.payroll.ui.LoansList;
import hashwork.repository.payroll.ui.Impl.LoansListRepositoryImpl;
import hashwork.repository.payroll.ui.LoansListRepository;
import hashwork.services.payroll.ui.LoansListService;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/03.
 */
public class LoansListServiceImpl implements LoansListService {
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

