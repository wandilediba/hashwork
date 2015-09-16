/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.ui.education.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.education.Evaluation;
import hashwork.repository.ui.education.EvaluationRepository;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.redisson.Redisson;
import org.redisson.core.RMap;

/**
 *
 * @author BKLAAS1
 */
public class EvaluationRepositoryImpl implements EvaluationRepository{

    Redisson redisson = Connection.getConnection();
    RMap<String, Evaluation> lists = redisson.getMap("addresstype");
    
    @Override
    public Evaluation findById(String s) {
         return lists.get(s);
    }

    @Override
    public Evaluation save(Evaluation entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public Evaluation update(Evaluation entity) {
       return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Evaluation entity) {
      lists.remove(entity.getId());
    }

    @Override
    public Set<Evaluation> findAll() {
      Set<Evaluation> set = new HashSet<>();
        for (Map.Entry<String, Evaluation> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
