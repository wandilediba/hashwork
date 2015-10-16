/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.people;

import hashwork.domain.people.PersonAttachment;
import hashwork.factories.people.PersonAttachmentFactory;
import hashwork.repository.people.Impl.PersonAttachmentRepositoryImpl;
import hashwork.repository.people.PersonAttachmentRepository;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;



/**
 *
 * @author BKLAAS1
 */
public class PersonAttachmentTest {
    
   private PersonAttachmentRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonAttachmentRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        PersonAttachment attachment1 = PersonAttachmentFactory.getPersonAttachment("test1", "test1");
        PersonAttachment attachment2 = PersonAttachmentFactory.getPersonAttachment("test2", "Test2");
        PersonAttachment attachment3 = PersonAttachmentFactory.getPersonAttachment("test3", "Test3");
        
        System.out.println(" Role 1 " + attachment1.getId());
        System.out.println(" Role 2 " + attachment2.getId());
        System.out.println(" Role 3 " + attachment3);
        repo.save(attachment1);
        Assert.assertNotNull(attachment1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonAttachment personAttachment = repo.findById(id);
        Assert.assertNotNull(personAttachment);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonAttachment personAttachment = repo.findById(id);
        PersonAttachment newPersonAttachment = new PersonAttachment.Builder().copy(personAttachment).fileName("TEST").build();
        repo.update(newPersonAttachment);
        PersonAttachment updatedPersonAttachment = repo.findById(id);
        Assert.assertEquals("TEST", updatedPersonAttachment.getFileName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonAttachment personAttachment = repo.findById(id);
        repo.delete(personAttachment);
        PersonAttachment deletedAttachment = repo.findById(id);
        Assert.assertNull(deletedAttachment);
    }
}
