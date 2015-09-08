/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.Impl;

import hashwork.domain.payroll.core.EmployeeTaxCertificate;
import hashwork.repository.payroll.core.EmployeeTaxCertificateRepository;
import hashwork.repository.payroll.core.Impl.EmployeeTaxCertificateRepositoryImpl;
import hashwork.services.payroll.core.EmployeeTaxCertificateService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeTaxCertificateServiceImpl implements EmployeeTaxCertificateService{
private final EmployeeTaxCertificateRepository repo = new EmployeeTaxCertificateRepositoryImpl();
    @Override
    public EmployeeTaxCertificate findById(String s) {
        return repo.findById(s);
    }

    @Override
    public EmployeeTaxCertificate save(EmployeeTaxCertificate entity) {
        return repo.save(entity);
    }

    @Override
    public EmployeeTaxCertificate update(EmployeeTaxCertificate entity) {
       return repo.save(entity);
    }

    @Override
    public void delete(EmployeeTaxCertificate entity) {
        repo.delete(entity);
    }

    @Override
    public Set<EmployeeTaxCertificate> findAll() {
       return repo.findAll();
    }
    
}
