package hashwork.services.payroll.ui.job.Impl;

import hashwork.domain.payroll.ui.job.BenefitFrequency;
import hashwork.repository.payroll.ui.job.Impl.BenefitFrequencyRepositoryImpl;
import hashwork.services.payroll.ui.job.BenefitFrequencyService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/15.
 */
public class BenefitFrequencyServiceImpl implements BenefitFrequencyService {
    @Override
    public BenefitFrequency findById(String id) {
        return new BenefitFrequencyRepositoryImpl().findById(id);
    }

    @Override
    public BenefitFrequency save(BenefitFrequency entity) {
        return new BenefitFrequencyRepositoryImpl().save(entity);
    }

    @Override
    public BenefitFrequency update(BenefitFrequency entity) {
        return new BenefitFrequencyRepositoryImpl().update(entity);
    }

    @Override
    public void delete(BenefitFrequency entity) {
        new BenefitFrequencyRepositoryImpl().delete(entity);

    }

    @Override
    public Set<BenefitFrequency> findAll() {
        return new BenefitFrequencyRepositoryImpl().findAll();
    }
}
