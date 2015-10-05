package hashwork.services.payroll.core.Impl;

import hashwork.domain.payroll.core.EmployeePayslip;
import hashwork.repository.payroll.core.Impl.EmployeePayslipRepositoryImpl;
import hashwork.services.payroll.core.EmployeePayslipService;

import java.util.Set;

/**
 * Created by nkosi on 2015/09/14.
 */
public class EmployeePayslipServiceImpl implements EmployeePayslipService {
    @Override
    public EmployeePayslip findById(String id) {

        return new EmployeePayslipRepositoryImpl().findById(id);
    }

    @Override
    public EmployeePayslip save(EmployeePayslip entity) {

        return new EmployeePayslipRepositoryImpl().save(entity);
    }

    @Override
    public EmployeePayslip update(EmployeePayslip entity) {

        return new EmployeePayslipRepositoryImpl().update(entity);
    }

    @Override
    public void delete(EmployeePayslip entity) {
        new EmployeePayslipRepositoryImpl().delete(entity);
    }

    @Override
    public Set<EmployeePayslip> findAll() {

        return new EmployeePayslipServiceImpl().findAll();
    }
}
