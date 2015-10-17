/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people;

import hashwork.domain.people.PersonBenefitsFundingSource;
import hashwork.factories.people.PersonBenefitsSourceFactory;
import hashwork.repository.people.Impl.PersonBenefitsFundingSourceRepositoryImpl;
import hashwork.repository.people.PersonBenefitsFundingSourceRepository;
import java.math.BigDecimal;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


/**
 *
 * @author BKLAAS1
 */
public class PersonBenefitsFundingSourceTest {
    
    private PersonBenefitsFundingSourceRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonBenefitsFundingSourceRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        BigDecimal amount = new BigDecimal("500.00");
        PersonBenefitsFundingSource PersonBenifitsFundingSource1 = PersonBenefitsSourceFactory.getPersonBenefitsFundingSource("Test1", "Test2",amount, "Test3");
        PersonBenefitsFundingSource PersonBenifitsFundingSource2 = PersonBenefitsSourceFactory.getPersonBenefitsFundingSource("Test1", "Test2",amount, "Test3");
        PersonBenefitsFundingSource PersonBenifitsFundingSource3 = PersonBenefitsSourceFactory.getPersonBenefitsFundingSource("Test1", "Test2",amount, "Test3");
        
        System.out.println(" PersonBenifitsFundingSource 1 " + PersonBenifitsFundingSource1.getId());
        System.out.println(" PersonBenifitsFundingSource 2 " + PersonBenifitsFundingSource2.getId());
        System.out.println(" PersonBenifitsFundingSource 3 " + PersonBenifitsFundingSource3);
        repo.save(PersonBenifitsFundingSource1);
        Assert.assertNotNull(PersonBenifitsFundingSource1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonBenefitsFundingSource personBenifitsFundingSource = repo.findById(id);
        Assert.assertNotNull(personBenifitsFundingSource);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonBenefitsFundingSource benefitsFundingSource = repo.findById(id);
        PersonBenefitsFundingSource newPersonBenifitsFundingSource = new PersonBenefitsFundingSource.Builder().copy(benefitsFundingSource).personId("TEST").build();
        repo.update(newPersonBenifitsFundingSource);
        PersonBenefitsFundingSource updatedPersonBenifitsFundingSource = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonBenifitsFundingSource.getPersonId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonBenefitsFundingSource personBenefitsFundingSource = repo.findById(id);
        repo.delete(personBenefitsFundingSource);
        PersonBenefitsFundingSource deletedBenefitsFundingSource = repo.findById(id);
        Assert.assertNull(deletedBenefitsFundingSource);
    }
}
