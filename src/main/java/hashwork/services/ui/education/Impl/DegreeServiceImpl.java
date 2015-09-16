/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.ui.education.Impl;

import hashwork.domain.ui.education.Degree;
import hashwork.repository.ui.education.Impl.DegreeRepositoryImpl;
import hashwork.services.ui.education.DegreeService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class DegreeServiceImpl implements DegreeService {

    @Override
    public Degree findById(String id) {
        return new DegreeRepositoryImpl().findById(id);
    }

    @Override
    public Degree save(Degree entity) {
        return new DegreeRepositoryImpl().save(entity);
    }

    @Override
    public Degree update(Degree entity) {
         return new DegreeRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Degree entity) {
       new DegreeRepositoryImpl().delete(entity);
    }

    @Override
    public Set<Degree> findAll() {
       return new DegreeRepositoryImpl().findAll();
    }
    
}
