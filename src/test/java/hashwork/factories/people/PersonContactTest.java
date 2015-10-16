/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonContact;
import hashwork.repository.people.Impl.PersonContactRepositoryImpl;
import hashwork.repository.people.PersonContactRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */
public class PersonContactTest {
    
    private PersonContactRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonContactRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        PersonContact contact1 = PersonContactFactory.getPersonContact("Test1","Test2","Test3","Test4");
        PersonContact contact2 = PersonContactFactory.getPersonContact("Test1","Test2","Test3","Test4");
        PersonContact contact3 = PersonContactFactory.getPersonContact("Test1","Test2","Test3","Test4");
        
        System.out.println(" Contact 1 " + contact1.getId());
        System.out.println(" Contact 2 " + contact2.getId());
        System.out.println(" Contact 3 " + contact3);
        repo.save(contact1);
        Assert.assertNotNull(contact1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonContact personContact = repo.findById(id);
        Assert.assertNotNull(personContact);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonContact personContact = repo.findById(id);
        PersonContact newPersonContact = new PersonContact.Builder().copy(personContact).contactValue("TEST").build();
        repo.update(newPersonContact);
        PersonContact updatedPersonContact = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonContact.getContactValue());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonContact personContact = repo.findById(id);
        repo.delete(personContact);
        PersonContact deletedContact = repo.findById(id);
        Assert.assertNull(deletedContact);
    }
}
