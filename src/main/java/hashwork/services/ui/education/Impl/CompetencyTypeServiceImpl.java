/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.ui.education.Impl;

import hashwork.domain.ui.education.CompetencyType;
import hashwork.repository.ui.education.Impl.CompetencyTypeRepositoryImpl;
import hashwork.services.ui.education.CompetencyTypeService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class CompetencyTypeServiceImpl implements CompetencyTypeService{

    @Override
    public CompetencyType findById(String id) {
       return new CompetencyTypeRepositoryImpl().findById(id);
    }

    @Override
    public CompetencyType save(CompetencyType entity) {
        return new CompetencyTypeRepositoryImpl().save(entity);
    }

    @Override
    public CompetencyType update(CompetencyType entity) {
        return new CompetencyTypeRepositoryImpl().update(entity);
    }

    @Override
    public void delete(CompetencyType entity) {
        new CompetencyTypeRepositoryImpl().delete(entity);
    }

    @Override
    public Set<CompetencyType> findAll() {
       return new CompetencyTypeRepositoryImpl().findAll();
    }
    
}
