/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.ui.education.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.education.EducationType;
import hashwork.repository.ui.education.EducationTypeRepository;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 *
 * @author BKLAAS1
 */
public class EducationTypeRepositoryImpl implements EducationTypeRepository {

    Redisson redisson = Connection.getConnection();
    RMap<String, EducationType> lists = redisson.getMap("addresstype");
    
    @Override
    public EducationType findById(String s) {
         return lists.get(s);
    }

    @Override
    public EducationType save(EducationType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EducationType update(EducationType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EducationType entity) {
       lists.remove(entity.getId());
    }

    @Override
    public Set<EducationType> findAll() {
       Set<EducationType> set = new HashSet<>();
        for (Map.Entry<String, EducationType> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
