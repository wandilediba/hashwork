/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.payroll.core.Impl;

import hashwork.domain.payroll.core.TaxThresholds;
import hashwork.repository.payroll.core.Impl.TaxThresholdsRepositoryImpl;
import hashwork.repository.payroll.core.TaxThresholdsRepository;
import hashwork.services.payroll.core.TaxThresholdsService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class TaxThresholdsServiceImpl implements TaxThresholdsService{
private final TaxThresholdsRepository repo = new TaxThresholdsRepositoryImpl();
    @Override
    public TaxThresholds findById(String s) {
       return repo.findById(s);
    }

    @Override
    public TaxThresholds save(TaxThresholds entity) {
        return repo.save(entity);
    }

    @Override
    public TaxThresholds update(TaxThresholds entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(TaxThresholds entity) {
              repo.delete(entity);
    }

    @Override
    public Set<TaxThresholds> findAll() {
        return repo.findAll();
    }
    
}
