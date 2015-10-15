/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonRole;
import hashwork.factories.ui.demographics.PersonRoleFactory;
import hashwork.repository.people.Impl.PersonRoleRepositoryImpl;
import hashwork.repository.people.PersonRoleRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author BKLAAS1
 */
public class PersonRoleTest {
    
  private PersonRoleRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonRoleRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        PersonRole role1 = PersonRoleFactory.getPersonRole("12345", "123456");
        PersonRole role2 = PersonRoleFactory.getPersonRole("56789", "112233");
        PersonRole role3 = PersonRoleFactory.getPersonRole("444444", "555555");
        
        System.out.println(" PeronRole 1 " + role1.getId());
        System.out.println(" PeronRole 2 " + role2.getId());
        System.out.println(" PeronRole 3 " + role3);
        repo.save(role1);
        Assert.assertNotNull(role1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonRole personRole = repo.findById(id);
        Assert.assertNotNull(personRole);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonRole personRole = repo.findById(id);
        PersonRole newPersonRole = new PersonRole.Builder().copy(personRole).roleId("TESTING").build();
        repo.update(newPersonRole);
        PersonRole updatedPersonRole = repo.findById(id);
        Assert.assertEquals("TESTING", updatedPersonRole.getRoleId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonRole personRole = repo.findById(id);
        repo.delete(personRole);
        PersonRole deletedDPersonRole = repo.findById(id);
        Assert.assertNull(deletedDPersonRole);
    }
}
