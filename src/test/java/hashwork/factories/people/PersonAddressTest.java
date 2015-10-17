/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonAddress;
import hashwork.repository.people.Impl.PersonAddressRepositoryImpl;
import hashwork.repository.people.PersonAddressRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */
public class PersonAddressTest {
    
    private PersonAddressRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonAddressRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        PersonAddress address1 = PersonAddressFactory.getPersonAddress("Test", "Test1","Test2", "Test3");
        PersonAddress address2 = PersonAddressFactory.getPersonAddress("Test", "Test1","Test2", "Test3");
        PersonAddress address3 = PersonAddressFactory.getPersonAddress("Test", "Test1","Test2", "Test3");
        
        System.out.println(" address 1 " + address1.getId());
        System.out.println(" address 2 " + address2.getId());
        System.out.println(" address 3 " + address3);
        repo.save(address1);
        Assert.assertNotNull(address1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonAddress personAddress = repo.findById(id);
        Assert.assertNotNull(personAddress);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonAddress personAddress = repo.findById(id);
        PersonAddress newPersonAddress = new PersonAddress.Builder().copy(personAddress).description("Test").build();
        repo.update(newPersonAddress);
        PersonAddress updatedPersonAddress = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonAddress.getDescription());
                
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonAddress personAddress = repo.findById(id);
        repo.delete(personAddress);
        PersonAddress deletedAddress = repo.findById(id);
        Assert.assertNull(deletedAddress);
    }
}
