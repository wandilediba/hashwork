/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.education;

import hashwork.repository.ui.education.*;
import hashwork.domain.ui.education.CompetencyType;
import hashwork.factories.ui.education.CompetencyTypeFactory;
import hashwork.repository.ui.education.Impl.CompetencyTypeRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author VUYO
 */
public class CompetencyTypeTest {
    
    
     private CompetencyTypeRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new CompetencyTypeRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        CompetencyType competencyType1 = CompetencyTypeFactory.getCompetencyType("Computer Skills");
        CompetencyType competencyType2 = CompetencyTypeFactory.getCompetencyType("Accounting base");
        CompetencyType competencyType3 = CompetencyTypeFactory.getCompetencyType("cient interaction");
        id = competencyType1.getId();
        System.out.println(" competency 1 " + competencyType1.getId());
        System.out.println(" competency 2 " + competencyType2.getId());
        System.out.println(" competency 3 " + competencyType3);
        repo.save(competencyType1);
        Assert.assertNotNull(competencyType1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        CompetencyType competencyType = repo.findById(id);
        Assert.assertNotNull(competencyType);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        CompetencyType competencyType = repo.findById(id);
        CompetencyType newCompetencyType = new CompetencyType.Builder().copy(competencyType).name("TEST").build();
        repo.update(newCompetencyType);
        CompetencyType updatedCompetencyType = repo.findById(id);
        Assert.assertEquals("TEST", updatedCompetencyType.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        CompetencyType competency = repo.findById(id);
        repo.delete(competency);
        CompetencyType deletedCompetencyType = repo.findById(id);
        Assert.assertNull(deletedCompetencyType);


    }
    
}
