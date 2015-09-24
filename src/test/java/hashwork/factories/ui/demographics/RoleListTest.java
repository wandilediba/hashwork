package hashwork.factories.ui.demographics;

import hashwork.domain.ui.demographics.RolesList;
import hashwork.repository.ui.demographics.Impl.RolesListRepositoryImpl;
import hashwork.repository.ui.demographics.RolesListRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by hashcode on 2015/08/24.
 */
public class RoleListTest {
    private RolesListRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new RolesListRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        RolesList role1 = RolesListFactory.getRolesList("WORKER", "Normal Worker");
        RolesList role2 = RolesListFactory.getRolesList("APPLICANT", "Prospective Employee");
        RolesList role3 = RolesListFactory.getRolesList("PANELIST", "Member of the Panel");
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
