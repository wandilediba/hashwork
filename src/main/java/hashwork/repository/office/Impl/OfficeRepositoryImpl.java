/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.office.Impl;
import hashwork.domain.office.Office;
import hashwork.repository.office.OfficeRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class OfficeRepositoryImpl implements OfficeRepository{
     Map<String, Office> lists = new HashMap<>();  
 
   public OfficeRepositoryImpl() {

    }
    @Override
    public Office findById(String s) {
     return lists.get(s);
    }

    @Override
    public Office save(Office entity) {
     return lists.put(entity.getId(), entity);
    }

    @Override
    public Office update(Office entity) {
     return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Office entity) {
     lists.remove(entity.getId());     
    }

    @Override
    public Set<Office> findAll() {
    Set<Office> set = new HashSet<>();
        for (Map.Entry<String, Office> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;    
    }
   
}
