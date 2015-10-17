/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonIdentity;
import hashwork.repository.people.Impl.PersonIdentityRepositoryImpl;
import hashwork.repository.people.PersonIdentityRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author BKLAAS1
 */
public class PersonIdentityTest {
    
     private PersonIdentityRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonIdentityRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        
        boolean preffered = true;
        
        PersonIdentity identity1 = PersonIdentityFactory.getPersonIdentity("Test1","Test2","Test3",preffered);
        PersonIdentity identity2 = PersonIdentityFactory.getPersonIdentity("Test1","Test2","Test3",preffered);
        PersonIdentity identity3 = PersonIdentityFactory.getPersonIdentity("Test1","Test2","Test3",preffered);
        
        System.out.println(" Identity 1 " + identity1.getId());
        System.out.println(" Identity 2 " + identity2.getId());
        System.out.println(" Identity 3 " + identity3);
        repo.save(identity1);
        Assert.assertNotNull(identity1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonIdentity personIdentity = repo.findById(id);
        Assert.assertNotNull(personIdentity);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonIdentity personIdentity = repo.findById(id);
        PersonIdentity newPersonIdentity = new PersonIdentity.Builder().copy(personIdentity).idType("TEST").build();
        repo.update(newPersonIdentity);
        PersonIdentity updatedPersonIdentity = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonIdentity.getIdType());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonIdentity personIdentity = repo.findById(id);
        repo.delete(personIdentity);
        PersonIdentity deletedDolesList = repo.findById(id);
        Assert.assertNull(deletedDolesList);
    }
}
