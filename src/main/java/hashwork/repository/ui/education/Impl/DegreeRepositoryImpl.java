/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.ui.education.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.education.Competency;
import hashwork.domain.ui.education.CompetencyType;
import hashwork.domain.ui.education.Degree;
import hashwork.repository.ui.education.DegreeRepository;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 *
 * @author BKLAAS1
 */
public class DegreeRepositoryImpl implements DegreeRepository {
  Redisson redisson = Connection.getConnection();
    RMap<String, Degree> lists = redisson.getMap("addresstype");
    
    @Override
    public Degree findById(String s) {
         return lists.get(s);
    }

    @Override
    public Degree save(Degree entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Degree update(Degree entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Degree entity) {
       lists.remove(entity.getId());
    }


    @Override
    public Set<Degree> findAll() {
       Set<Degree> set = new HashSet<>();
        for (Map.Entry<String, Degree> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
