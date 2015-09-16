/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.ui.education.Impl;

import hashwork.domain.ui.education.EducationType;
import hashwork.repository.ui.education.Impl.EducationTypeRepositoryImpl;
import hashwork.services.ui.education.EducationTypeService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EducationTypeServiceImpl implements EducationTypeService{

    @Override
    public EducationType findById(String id) {
        return new EducationTypeRepositoryImpl().findById(id);
    }

    @Override
    public EducationType save(EducationType entity) {
         return new EducationTypeRepositoryImpl().save(entity);
    }

    @Override
    public EducationType update(EducationType entity) {
       return new EducationTypeRepositoryImpl().update(entity);
    }

    @Override
    public void delete(EducationType entity) {
         new EducationTypeRepositoryImpl().delete(entity);
    }

    @Override
    public Set<EducationType> findAll() {
         return new EducationTypeRepositoryImpl().findAll();
    }
    
}
