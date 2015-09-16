/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.ui.education.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.education.Competency;
import hashwork.domain.ui.education.CompetencyType;
import hashwork.repository.ui.education.CompetencyTypeRepository;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 *
 * @author BKLAAS1
 */
public class CompetencyTypeRepositoryImpl implements CompetencyTypeRepository {

      Redisson redisson = Connection.getConnection();
    RMap<String, CompetencyType> lists = redisson.getMap("addresstype");
    
    @Override
    public CompetencyType findById(String s) {
        return lists.get(s);
    }

    @Override
    public CompetencyType save(CompetencyType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public CompetencyType update(CompetencyType entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(CompetencyType entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<CompetencyType> findAll() {
       Set<CompetencyType> set = new HashSet<>();
        for (Map.Entry<String, CompetencyType> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
}
