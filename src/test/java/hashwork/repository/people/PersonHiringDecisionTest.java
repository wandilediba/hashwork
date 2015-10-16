/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people;

import hashwork.domain.people.PersonHiringDecision;
import hashwork.factories.people.PersonHiringDecisionFactory;
import hashwork.repository.people.Impl.PersonHiringDecisionRepositoryImpl;
import hashwork.repository.people.PersonHiringDecisionRepository;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */
public class PersonHiringDecisionTest {
    
    private PersonHiringDecisionRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonHiringDecisionRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Date date = new Date();
        PersonHiringDecision hiringdecision1 = PersonHiringDecisionFactory.getPersonHiringDecision("Test1",date,"Test3","Test4","Test5");
        PersonHiringDecision hiringdecision2 = PersonHiringDecisionFactory.getPersonHiringDecision ("Test1",date,"Test3","Test4","Test5");
        PersonHiringDecision hiringdecision3 = PersonHiringDecisionFactory.getPersonHiringDecision ("Test1",date,"Test3","Test4","Test5");
        //HiringDecision
        System.out.println(" HiringDecision 1 " + hiringdecision1.getId());
        System.out.println(" HiringDecision 2 " + hiringdecision2.getId());
        System.out.println(" HiringDecision 3 " + hiringdecision3);
        repo.save(hiringdecision1);
        Assert.assertNotNull(hiringdecision1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonHiringDecision hiringDecision = repo.findById(id);
        Assert.assertNotNull(hiringDecision);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonHiringDecision hiringDecision = repo.findById(id);
        PersonHiringDecision newPersonHiringDecision = new PersonHiringDecision.Builder().copy(hiringDecision).decisionMakerId("TEST").build();
        repo.update(newPersonHiringDecision);
        PersonHiringDecision updatedPersonHiringDecision = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonHiringDecision.getDecisionMakerId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonHiringDecision hiringDecision = repo.findById(id);
        repo.delete(hiringDecision);
        PersonHiringDecision deletedDolesList = repo.findById(id);
        Assert.assertNull(deletedDolesList);
    }
}
