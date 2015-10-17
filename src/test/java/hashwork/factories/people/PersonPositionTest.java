/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonPosition;
import hashwork.repository.people.Impl.PersonPositionRepositoryImpl;
import hashwork.repository.people.PersonPositionRepository;
import java.math.BigDecimal;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */

public class PersonPositionTest {
    
     private PersonPositionRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonPositionRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
         BigDecimal amount = new BigDecimal("500.00");
         Date date = new Date();
        PersonPosition personposition1 = PersonPositionFactory.getPersonPosition("Test1","Test2",date,date,"Test3",amount,"Test4",date,"Test5");
        PersonPosition personposition2 = PersonPositionFactory.getPersonPosition ("Test1","Test2",date,date,"Test3",amount,"Test4",date,"Test5");
        PersonPosition personposition3 = PersonPositionFactory.getPersonPosition ("Test1","Test2",date,date,"Test3",amount,"Test4",date,"Test5");
        
        System.out.println(" PersonPosition 1 " + personposition1.getId());
        System.out.println(" PersonPosition 2 " + personposition2.getId());
        System.out.println(" PersonPosition 3 " + personposition3);
        repo.save(personposition1);
        Assert.assertNotNull(personposition1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonPosition personPosition = repo.findById(id);
        Assert.assertNotNull(personPosition);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonPosition personPosition = repo.findById(id);
        PersonPosition newPersonPosition = new PersonPosition.Builder().copy(personPosition).statusId("Technical").build();
        repo.update(newPersonPosition);
        PersonPosition updatedPersonPosition = repo.findById(id);
        Assert.assertEquals("Technical", updatedPersonPosition.getStatusId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonPosition personPosition = repo.findById(id);
        repo.delete(personPosition);
        PersonPosition deletedPersonPosition = repo.findById(id);
        Assert.assertNull(deletedPersonPosition);
    }
  
}
