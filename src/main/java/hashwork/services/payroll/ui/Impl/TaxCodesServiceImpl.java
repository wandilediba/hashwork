package hashwork.services.payroll.ui.Impl;

import hashwork.domain.payroll.ui.TaxCodes;
import hashwork.repository.payroll.ui.Impl.TaxCodesRepositoryImpl;
import hashwork.repository.payroll.ui.TaxCodesRepository;
import hashwork.services.payroll.ui.TaxCodesService;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/03.
 */
public class TaxCodesServiceImpl implements TaxCodesService {
    private final TaxCodesRepository repo = new TaxCodesRepositoryImpl();

    @Override
    public TaxCodes findById(String s) {
        return repo.findById(s);
    }

    @Override
    public TaxCodes save(TaxCodes entity) {
        return repo.save(entity);
    }

    @Override
    public TaxCodes update(TaxCodes entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(TaxCodes entity) {
        repo.delete(entity);
    }

    @Override
    public Set<TaxCodes> findAll() {
        return repo.findAll();
    }
}
