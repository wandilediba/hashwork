package hashwork.services.payroll.ui.job.Impl;

import hashwork.domain.payroll.ui.job.BenefitType;
import hashwork.repository.payroll.ui.job.Impl.BenefitTypeRepositoryImpl;
import hashwork.services.payroll.ui.job.BenefitTypeService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/15.
 */
public class BenefitTypeServiceImpl implements BenefitTypeService {
    @Override
    public BenefitType findById(String id) {
        return new BenefitTypeRepositoryImpl().findById(id);
    }

    @Override
    public BenefitType save(BenefitType entity) {
        return new BenefitTypeRepositoryImpl().save(entity);
    }

    @Override
    public BenefitType update(BenefitType entity) {
        return new BenefitTypeRepositoryImpl().update(entity);
    }

    @Override
    public void delete(BenefitType entity) {
        new BenefitTypeRepositoryImpl().delete(entity);

    }

    @Override
    public Set<BenefitType> findAll() {
        return new BenefitTypeRepositoryImpl().findAll();
    }
}
