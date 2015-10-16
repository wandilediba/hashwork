/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people;

import hashwork.domain.people.PersonInterviewFeedback;
import hashwork.factories.people.PersonInterviewFeedbackFactory;
import hashwork.repository.people.Impl.PersonInterviewFeedbackRepositoryImpl;
import hashwork.repository.people.PersonInterviewFeedbackRepository;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author BKLAAS1
 */
public class PersonInterviewFeedbackTest {
    
     private PersonInterviewFeedbackRepository repo;
     private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonInterviewFeedbackRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Date date = new Date();
        PersonInterviewFeedback interviewfeedback1 = PersonInterviewFeedbackFactory.getPersonInterviewFeedback("Test1","Test2",date,"Test3",3);
        PersonInterviewFeedback interviewfeedback2 = PersonInterviewFeedbackFactory.getPersonInterviewFeedback ("Test1","Test2",date,"Test3",3);
        PersonInterviewFeedback interviewfeedback3 = PersonInterviewFeedbackFactory.getPersonInterviewFeedback ("Test1","Test2",date,"Test3",3);
        
        System.out.println("Interviewfeedback 1 " + interviewfeedback1.getId());
        System.out.println("Interviewfeedback 2 " + interviewfeedback2.getId());
        System.out.println("Interviewfeedback 3 " + interviewfeedback3);
        repo.save(interviewfeedback1);
        Assert.assertNotNull(interviewfeedback1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonInterviewFeedback interviewFeedback = repo.findById(id);
        Assert.assertNotNull(interviewFeedback);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonInterviewFeedback interviewFeedback = repo.findById(id);
        PersonInterviewFeedback newPersonInterviewFeedback = new PersonInterviewFeedback.Builder().copy(interviewFeedback).comments("TEST").build();
        repo.update(newPersonInterviewFeedback);
        PersonInterviewFeedback updatedPersonInterviewFeedback = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonInterviewFeedback.getComments());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonInterviewFeedback interviewFeedback = repo.findById(id);
        repo.delete(interviewFeedback);
        PersonInterviewFeedback deletedInterviewFeedback = repo.findById(id);
        Assert.assertNull(deletedInterviewFeedback);
    }
}
