/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.education;

import hashwork.repository.ui.education.*;
import hashwork.domain.ui.education.Competency;
import hashwork.factories.ui.education.CompetencyFactory;
import hashwork.repository.ui.education.Impl.CompetencyRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author VUYO
 */

public class CompetencyTest {
    
     private CompetencyRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new CompetencyRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Competency competency1 = CompetencyFactory.getCompetency("COMPUTER SKILLS","COMP","computer literacy");
        Competency competency2 = CompetencyFactory.getCompetency("DATA ENTRY", "DE","Data formating");
        Competency competency3 = CompetencyFactory.getCompetency("SOFTWARE", "SOFT","software dowloads");
        Competency competency4 = CompetencyFactory.getCompetency("DOCUMENT FORMARTING", "DF","format");
        id = competency1.getId();
        System.out.println(" competency 1 " + competency1.getId());
        System.out.println(" competency 2 " + competency2.getId());
        System.out.println(" competency 3 " + competency3);
        repo.save(competency1);
        Assert.assertNotNull(competency1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Competency competency = repo.findById(id);
        Assert.assertNotNull(competency);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Competency competency = repo.findById(id);
        Competency newCompetency = new Competency.Builder().copy(competency).name("TEST").build();
        repo.update(newCompetency);
        Competency updatedCompetency = repo.findById(id);
        Assert.assertEquals("TEST", updatedCompetency.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Competency competency = repo.findById(id);
        repo.delete(competency);
        Competency deletedCompetency = repo.findById(id);
        Assert.assertNull(deletedCompetency);


    }
    
    
    
}
