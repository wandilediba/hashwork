/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.payroll.core.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.core.TaxThresholds;
import hashwork.repository.payroll.core.TaxThresholdsRepository;
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
public class TaxThresholdsRepositoryImpl implements TaxThresholdsRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, TaxThresholds> lists = redisson.getMap("taxThresholds");
  
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
