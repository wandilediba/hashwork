/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.ui.education.Impl;

import hashwork.domain.ui.education.Competency;
import hashwork.repository.ui.education.Impl.CompetencyRepositoryImpl;
import hashwork.services.ui.education.CompetencyService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class CompetencyServiceImpl implements CompetencyService {

    @Override
    public Competency findById(String id) {
        return new CompetencyRepositoryImpl().findById(id);
    }

    @Override
    public Competency save(Competency entity) {
         return new CompetencyRepositoryImpl().save(entity);
    }

    @Override
    public Competency update(Competency entity) {
         return new CompetencyRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Competency entity) {
        new CompetencyRepositoryImpl().delete(entity);
    }

    @Override
    public Set<Competency> findAll() {
        return new CompetencyRepositoryImpl().findAll();
    }
    
}
