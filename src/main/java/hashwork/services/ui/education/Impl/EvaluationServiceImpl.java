/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.ui.education.Impl;

import hashwork.domain.ui.education.Evaluation;
import hashwork.repository.ui.education.Impl.EvaluationRepositoryImpl;
import hashwork.services.ui.education.EvaluationService;
import java.util.Set;

/**
 *
 * @author BKLAAS1
 */
public class EvaluationServiceImpl implements EvaluationService{

    @Override
    public Evaluation findById(String id) {
       return new EvaluationRepositoryImpl().findById(id);
    }

    @Override
    public Evaluation save(Evaluation entity) {
       return new EvaluationRepositoryImpl().save(entity);
    }

    @Override
    public Evaluation update(Evaluation entity) {
        return new EvaluationRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Evaluation entity) {
        new EvaluationRepositoryImpl().delete(entity);
    }

    @Override
    public Set<Evaluation> findAll() {
       return new EvaluationRepositoryImpl().findAll();
    }
    
}
