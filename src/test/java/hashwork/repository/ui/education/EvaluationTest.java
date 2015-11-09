/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.ui.education;

import hashwork.domain.ui.education.Evaluation;
import hashwork.factories.ui.education.EvaluationFactory;
import hashwork.repository.ui.education.Impl.EvaluationRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author VUYO
 */
public class EvaluationTest {
    
    
    private EvaluationRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new EvaluationRepositoryImpl();
    }
    
     @Test
    public void create() throws Exception {
        Evaluation evaluation1 = EvaluationFactory.getEvaluation(" competent");
        Evaluation evaluation2 = EvaluationFactory.getEvaluation("not competent");
        Evaluation evaluation3 = EvaluationFactory.getEvaluation("not assessed");
        id = evaluation1.getId();
        System.out.println(" Evaluation 1 " + evaluation1.getId());
        System.out.println(" Evaluation 2 " + evaluation2.getId());
        System.out.println(" Evaluation 3 " + evaluation3);
        repo.save(evaluation1);
        Assert.assertNotNull(evaluation1.getId());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Evaluation evaluation = repo.findById(id);
        Assert.assertNotNull(evaluation);
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Evaluation evaluation = repo.findById(id);
        Evaluation newEvaluation = new Evaluation.Builder().copy(evaluation).name("TEST").build();
        repo.update(newEvaluation);
        Evaluation updatedEvaluation = repo.findById(id);
        Assert.assertEquals("TEST", updatedEvaluation.getName());
    }
    
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Evaluation evaluation = repo.findById(id);
        repo.delete(evaluation);
        Evaluation deletedEvaluation = repo.findById(id);
        Assert.assertNull(deletedEvaluation);


    }
    
}
