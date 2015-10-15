/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonEducationHistory;
import hashwork.repository.people.Impl.PersonEducationHistoryRepositoryImpl;
import hashwork.repository.people.PersonEducationHistoryRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */
public class PersonEducationHistoryTest {
    
    private PersonEducationHistoryRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonEducationHistoryRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        PersonEducationHistory educationhistory1 = PersonEducationHistoryFactory.getPersonEducationHistory("Test1","Test2","Test3",2,"Test4","Test5","Test6");
        PersonEducationHistory educationhistory2 = PersonEducationHistoryFactory.getPersonEducationHistory ("Test1","Test2","Test3",2,"Test4","Test5","Test6");
        PersonEducationHistory educationhistory3 = PersonEducationHistoryFactory.getPersonEducationHistory ("Test1","Test2","Test3",2,"Test4","Test5","Test6");
        
        System.out.println(" EducationHistory 1 " + educationhistory1.getId());
        System.out.println(" EducationHistory 2 " + educationhistory2.getId());
        System.out.println(" EducationHistory 3 " + educationhistory3);
        repo.save(educationhistory1);
        Assert.assertNotNull(educationhistory1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonEducationHistory personEducationHistory = repo.findById(id);
        Assert.assertNotNull(personEducationHistory);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonEducationHistory personEducationHistory = repo.findById(id);
        PersonEducationHistory newPersonEducationHistory = new PersonEducationHistory.Builder().copy(personEducationHistory).institutionName("TEST").build();
        repo.update(newPersonEducationHistory);
        PersonEducationHistory updatedPersonEducationHistory = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonEducationHistory.getInstitutionName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonEducationHistory personEducationHistory = repo.findById(id);
        repo.delete(personEducationHistory);
        PersonEducationHistory deletedEducationHistory = repo.findById(id);
        Assert.assertNull(deletedEducationHistory);
    }
}
