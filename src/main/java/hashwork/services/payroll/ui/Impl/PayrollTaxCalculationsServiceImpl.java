package hashwork.services.payroll.ui.Impl;

import hashwork.domain.payroll.ui.PayrollTaxCalculations;
import hashwork.repository.payroll.ui.Impl.PayrollTaxCalculationsRepositoryImpl;
import hashwork.repository.payroll.ui.PayrollTaxCalculationsRepository;
import hashwork.services.payroll.ui.PayrollTaxCalculationsService;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/03.
 */
public class PayrollTaxCalculationsServiceImpl implements PayrollTaxCalculationsService {
    private final PayrollTaxCalculationsRepository repo = new PayrollTaxCalculationsRepositoryImpl();

    @Override
    public PayrollTaxCalculations findById(String s) {
        return repo.findById(s);
    }

    @Override
    public PayrollTaxCalculations save(PayrollTaxCalculations entity) {
        return repo.save(entity);
    }

    @Override
    public PayrollTaxCalculations update(PayrollTaxCalculations entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(PayrollTaxCalculations entity) {
        repo.delete(entity);
    }

    @Override
    public Set<PayrollTaxCalculations> findAll() {
        return repo.findAll();
    }
}
