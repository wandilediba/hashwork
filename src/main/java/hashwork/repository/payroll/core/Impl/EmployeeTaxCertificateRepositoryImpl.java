/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.core.EmployeeTaxCertificate;
import hashwork.repository.payroll.core.EmployeeTaxCertificateRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EmployeeTaxCertificateRepositoryImpl implements EmployeeTaxCertificateRepository{
    Redisson redisson = Connection.getConnection();
    RMap<String, EmployeeTaxCertificate> lists = redisson.getMap("empTaxCertificate");
  
  public EmployeeTaxCertificateRepositoryImpl() {

    }
  
    @Override
    public EmployeeTaxCertificate findById(String s) {
         return lists.get(s);
    }

    @Override
    public EmployeeTaxCertificate save(EmployeeTaxCertificate entity) {
         return lists.put(entity.getId(), entity);
    }

    @Override
    public EmployeeTaxCertificate update(EmployeeTaxCertificate entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmployeeTaxCertificate entity) {
         lists.remove(entity.getId());
    }

    @Override
    public Set<EmployeeTaxCertificate> findAll() {
         Set<EmployeeTaxCertificate> set = new HashSet<>();
        for (Map.Entry<String, EmployeeTaxCertificate> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
