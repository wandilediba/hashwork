package hashwork.services.payroll.ui.job.Impl;

import hashwork.domain.payroll.ui.job.SalaryGrade;
import hashwork.repository.payroll.ui.job.Impl.SalaryGradeRepositoryImpl;
import hashwork.services.payroll.ui.job.SalaryGradeService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/15.
 */
public class SalaryGradeServiceImpl implements SalaryGradeService {

    @Override
    public SalaryGrade findById(String id) {
        return new SalaryGradeRepositoryImpl().findById(id);
    }

    @Override
    public SalaryGrade save(SalaryGrade entity) {
        return new SalaryGradeRepositoryImpl().save(entity);
    }

    @Override
    public SalaryGrade update(SalaryGrade entity) {
        return new SalaryGradeRepositoryImpl().update(entity);
    }

    @Override
    public void delete(SalaryGrade entity) {
        new SalaryGradeRepositoryImpl().delete(entity);

    }

    @Override
    public Set<SalaryGrade> findAll() {
        return new SalaryGradeRepositoryImpl().findAll();
    }
}
