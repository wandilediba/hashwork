/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.ui.education.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.education.Competency;
import hashwork.repository.ui.education.CompetencyRepository;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 *
 * @author BKLAAS1
 */
public class CompetencyRepositoryImpl implements CompetencyRepository {
   
    Redisson redisson = Connection.getConnection();
    RMap<String, Competency> lists = redisson.getMap("addresstype");
    
    @Override
    public Competency findById(String s) {
        return lists.get(s);
    }

    @Override
    public Competency save(Competency entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public Competency update(Competency entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Competency entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Competency> findAll() {
         Set<Competency> set = new HashSet<>();
        for (Map.Entry<String, Competency> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
