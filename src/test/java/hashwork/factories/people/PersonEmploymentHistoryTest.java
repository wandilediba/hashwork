/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonEmploymentHistory;
import hashwork.repository.people.Impl.PersonEmploymentHistoryRepositoryImpl;
import hashwork.repository.people.PersonEmploymentHistoryRepository;
import java.math.BigDecimal;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */
public class PersonEmploymentHistoryTest {
    
    private PersonEmploymentHistoryRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonEmploymentHistoryRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        BigDecimal amount = new BigDecimal("500.00");
        Date date = new Date(); 
        Boolean history = true;
                
        PersonEmploymentHistory employmenthistory1 = PersonEmploymentHistoryFactory.getPersonEmployement("Test1","Test2","Test3","Test4","Test5",history,"Test6",date,date,amount,amount,"Test7","Test8","Test");
        PersonEmploymentHistory employmenthistory2 = PersonEmploymentHistoryFactory.getPersonEmployement ("Test1","Test2","Test3","Test4","Test5",history,"Test6",date,date,amount,amount,"Test7","Test8","Test");
        PersonEmploymentHistory employmenthistory3 = PersonEmploymentHistoryFactory.getPersonEmployement ("Test1","Test2","Test3","Test4","Test5",history,"Test6",date,date,amount,amount,"Test7","Test8","Test");
        
        System.out.println(" EmploymentHistory1 1 " + employmenthistory1.getId());
        System.out.println(" EmploymentHistory1 2 " + employmenthistory2.getId());
        System.out.println(" EmploymentHistory1 3 " + employmenthistory3);
        repo.save(employmenthistory1);
        Assert.assertNotNull(employmenthistory1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonEmploymentHistory employmentHistory = repo.findById(id);
        Assert.assertNotNull(employmentHistory);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonEmploymentHistory employmentHistory = repo.findById(id);
        PersonEmploymentHistory newPersonEmploymentHistory = new PersonEmploymentHistory.Builder().copy(employmentHistory).companyName("TEST").build();
        repo.update(newPersonEmploymentHistory);
        PersonEmploymentHistory updatedPersonEmploymentHistory = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonEmploymentHistory.getCompanyName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonEmploymentHistory employmentHistory = repo.findById(id);
        repo.delete(employmentHistory);
        PersonEmploymentHistory deletedEmploymentHistory = repo.findById(id);
        Assert.assertNull(deletedEmploymentHistory);
    }
}
