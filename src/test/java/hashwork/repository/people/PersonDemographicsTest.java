/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people;

import hashwork.domain.people.PersonDemographics;
import hashwork.factories.people.PersonDemographicsFactory;
import hashwork.repository.people.Impl.PersonDemographicsRepositoryImpl;
import hashwork.repository.people.PersonDemographicsRepository;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */
public class PersonDemographicsTest {
    
     private PersonDemographicsRepository repo;
    private  String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonDemographicsRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Date date = new Date();
        PersonDemographics demographics1 = PersonDemographicsFactory.getPersonDemographics("Test1","Test2", date,"Test3", 2);
        PersonDemographics demographics2 = PersonDemographicsFactory.getPersonDemographics("Test1","Test2", date,"Test3", 2);
        PersonDemographics demographics3 = PersonDemographicsFactory.getPersonDemographics("Test1","Test2", date,"Test3", 2);
        
        System.out.println(" Demographics 1 " + demographics1.getId());
        System.out.println(" Demographics 2 " + demographics2.getId());
        System.out.println(" Demographics 3 " + demographics3);
        repo.save(demographics1);
        Assert.assertNotNull(demographics1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonDemographics personDemographics = repo.findById(id);
        Assert.assertNotNull(personDemographics);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonDemographics personDemographics = repo.findById(id);
        PersonDemographics newPersonDemographics = new PersonDemographics.Builder().copy(personDemographics).personId("TEST").build();
        repo.update(newPersonDemographics);
        PersonDemographics updatedPersonDemographics = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonDemographics.getPersonId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonDemographics personDemographics = repo.findById(id);
        repo.delete(personDemographics);
        PersonDemographics deletedDemographics = repo.findById(id);
        Assert.assertNull(deletedDemographics);
    }
}
