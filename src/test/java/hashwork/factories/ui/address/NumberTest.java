package hashwork.factories.ui.address;

import hashwork.repository.ui.address.NumberRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by garran on 2015/08/30.
 */
public class NumberTest {
    private NumberRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new NumberRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Number number1 = NumberFactory.getNumber("1");
        Number number2 = NumberFactory.getNumber("2");
        Number number3 = NumberFactory.getNumber("3");
        id = role1.getId();
        System.out.println(" Role 1 " + role1.getId());
        System.out.println(" Role 2 " + role2.getId());
        System.out.println(" Role 3 " + role3);
        repo.save(role1);
        Assert.assertNotNull(role1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        RolesList rolesList = repo.findById(id);
        Assert.assertNotNull(rolesList);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        RolesList rolesList = repo.findById(id);
        RolesList newRolesList = new RolesList.Builder().copy(rolesList).roleName("TEST").build();
        repo.update(newRolesList);
        RolesList updatedRolesList = repo.findById(id);
        Assert.assertEquals("TEST", updatedRolesList.getRoleName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        RolesList rolesList = repo.findById(id);
        repo.delete(rolesList);
        RolesList deletedDolesList = repo.findById(id);
        Assert.assertNull(deletedDolesList);


    }
}

