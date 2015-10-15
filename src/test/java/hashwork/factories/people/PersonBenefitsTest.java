/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonBenefits;
import hashwork.repository.people.Impl.PersonBenefitsRepositoryImpl;
import hashwork.repository.people.PersonBenefitsRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */
public class PersonBenefitsTest {
    
    private PersonBenefitsRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonBenefitsRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        BigDecimal amount = new BigDecimal("500.00");
        List<String> mylist = new ArrayList<String>();
        Date date = new Date();
        PersonBenefits personbenefits1 = PersonBenefitsFactory.getPersonBenefits("Test1","Test2",mylist,"Test3",date,date,"Test4",amount);
        PersonBenefits personbenefits2 = PersonBenefitsFactory.getPersonBenefits("Test1","Test2",mylist,"Test3",date,date,"Test4",amount);
        PersonBenefits personbenefits3 = PersonBenefitsFactory.getPersonBenefits("Test1","Test2",mylist,"Test3",date,date,"Test4",amount);
        
        System.out.println(" personbenefits 1 " + personbenefits1.getId());
        System.out.println(" personbenefits 2 " + personbenefits2.getId());
        System.out.println(" personbenefits 3 " + personbenefits3);
        repo.save(personbenefits1);
        Assert.assertNotNull(personbenefits1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonBenefits personBenefits = repo.findById(id);
        Assert.assertNotNull(personBenefits);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonBenefits personBenefits = repo.findById(id);
        PersonBenefits newPersonBenefits = new PersonBenefits.Builder().copy(personBenefits).benefitTypeId("TEST").build();
        repo.update(newPersonBenefits);
        PersonBenefits updatedPersonBenefits = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonBenefits.getBenefitTypeId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonBenefits personBenefits = repo.findById(id);
        repo.delete(personBenefits);
        PersonBenefits deletedBenefits = repo.findById(id);
        Assert.assertNull(deletedBenefits);
    }
}
