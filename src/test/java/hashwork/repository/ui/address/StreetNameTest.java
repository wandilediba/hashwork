package hashwork.repository.ui.address;

import hashwork.domain.ui.address.StreetName;
import hashwork.factories.ui.address.StreetNameFactory;
import hashwork.repository.ui.address.Impl.StreetNameRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by garran on 2015/08/30.
 */
public class StreetNameTest {
    private StreetNameRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new StreetNameRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        StreetName streetName1 = StreetNameFactory.getStreetName("Vent Road");
        StreetName streetName2 = StreetNameFactory.getStreetName("Blue Road");
        StreetName streetName3 = StreetNameFactory.getStreetName("High Road");
        id = streetName1.getId();
        System.out.println(" Street Name 1 " + streetName1.getId());
        System.out.println(" Street Name 2 " + streetName2.getId());
        System.out.println(" Street Name 3 " + streetName3);
        repo.save(streetName1);
        Assert.assertNotNull(streetName1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        StreetName streetName = repo.findById(id);
        Assert.assertNotNull(streetName);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        StreetName streetName = repo.findById(id);
        StreetName newRolesList = new StreetName.Builder().copy(streetName).streetName("TEST").build();
        repo.update(newRolesList);
        StreetName updatedStreetName = repo.findById(id);
        Assert.assertEquals("TEST", updatedStreetName.getStreetName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        StreetName rolesList = repo.findById(id);
        repo.delete(rolesList);
        StreetName deletedStreetName = repo.findById(id);
        Assert.assertNull(deletedStreetName);
    }
}
