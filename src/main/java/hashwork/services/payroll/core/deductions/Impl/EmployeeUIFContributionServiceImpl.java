/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.deductions.Impl;

import hashwork.domain.payroll.core.deductions.EmployeeUIFContribution;
import hashwork.repository.payroll.core.deductions.EmployeeUIFContributionRepository;
import hashwork.repository.payroll.core.deductions.Impl.EmployeeUIFContributionRepositoryImpl;
import hashwork.services.payroll.core.deductions.EmployeeUIFContributionService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeUIFContributionServiceImpl implements EmployeeUIFContributionService{
 private final EmployeeUIFContributionRepository repo = new EmployeeUIFContributionRepositoryImpl();
    @Override
    public EmployeeUIFContribution findById(String s) {
        return repo.findById(s);
    }

    @Override
    public EmployeeUIFContribution save(EmployeeUIFContribution entity) {
        return repo.save(entity);
    }

    @Override
    public EmployeeUIFContribution update(EmployeeUIFContribution entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(EmployeeUIFContribution entity) {
       repo.delete(entity);
    }

    @Override
    public Set<EmployeeUIFContribution> findAll() {
        return repo.findAll();
    }
    
}
