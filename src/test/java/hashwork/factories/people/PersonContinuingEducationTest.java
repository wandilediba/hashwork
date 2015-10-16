/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonContinuingEducation;
import hashwork.repository.people.Impl.PersonContinuingEducationRepositoryImpl;
import hashwork.repository.people.PersonContinuingEducationRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */
public class PersonContinuingEducationTest {
    
    private PersonContinuingEducationRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonContinuingEducationRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        PersonContinuingEducation education1 = PersonContinuingEducationFactory.getPersonContinuingEducation("Test1","Test2","Test3","Test4");
        PersonContinuingEducation education2 = PersonContinuingEducationFactory.getPersonContinuingEducation("Test1","Test2","Test3","Test4");
        PersonContinuingEducation education3 = PersonContinuingEducationFactory.getPersonContinuingEducation ("Test1","Test2","Test3","Test4");
        
        System.out.println(" Education 1 " + education1.getId());
        System.out.println(" Education 2 " + education2.getId());
        System.out.println(" Education 3 " + education3);
        repo.save(education1);
        Assert.assertNotNull(education1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonContinuingEducation personContinuingEducation = repo.findById(id);
        Assert.assertNotNull(personContinuingEducation);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonContinuingEducation personContinuingEducation = repo.findById(id);
        PersonContinuingEducation newPersonContinuingEducation = new PersonContinuingEducation.Builder().copy(personContinuingEducation).courseId("TEST").build();
        repo.update(newPersonContinuingEducation);
        PersonContinuingEducation updatedPersonContinuingEducation = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonContinuingEducation.getCourseId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonContinuingEducation personContinuingEducation = repo.findById(id);
        repo.delete(personContinuingEducation);
        PersonContinuingEducation deletedContinuingEducation = repo.findById(id);
        Assert.assertNull(deletedContinuingEducation);
    }
}
