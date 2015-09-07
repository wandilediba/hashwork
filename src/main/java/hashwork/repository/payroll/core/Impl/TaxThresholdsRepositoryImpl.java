/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.Impl;

import hashwork.domain.payroll.core.TaxThresholds;
import hashwork.domain.ui.demographics.GenderList;
import hashwork.repository.payroll.core.TaxThresholdsRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class TaxThresholdsRepositoryImpl implements TaxThresholdsRepository{
  Map<String, TaxThresholds> lists = new HashMap<>();
  
  public TaxThresholdsRepositoryImpl() {

    }
    @Override
    public TaxThresholds findById(String s) {
        return lists.get(s);
    }

    @Override
    public TaxThresholds save(TaxThresholds entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public TaxThresholds update(TaxThresholds entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(TaxThresholds entity) {
         lists.remove(entity.getId());
    }

    @Override
    public Set<TaxThresholds> findAll() {
       Set<TaxThresholds> set = new HashSet<>();
        for (Map.Entry<String, TaxThresholds> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
