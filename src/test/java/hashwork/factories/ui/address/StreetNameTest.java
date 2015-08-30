package hashwork.factories.ui.address;
import hashwork.domain.ui.address.StreetName;
import hashwork.repository.ui.address.Impl.StreetNameRepositoryImpl;
import hashwork.repository.ui.address.StreetNameRepository;
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
        StreetName streetName1 = StreetNameFactory.getStreetName("vent road");
        StreetName streetName2 = StreetNameFactory.getStreetName("blue road");
        StreetName streetName3 = StreetNameFactory.getStreetName("high road");
        id = streetName1.getId();
        System.out.println(" street Name 1 " + streetName1.getId());
        System.out.println(" street Name 2 " + streetName2.getId());
        System.out.println(" street Name 3 " + streetName3);
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
        StreetName newStreetName = new StreetName.Builder().copy(streetName).streetName("1").build();
        repo.update(newStreetName);
        StreetName updatedStreetName = repo.findById(id);
        Assert.assertEquals("1", updatedStreetName.getStreetName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        StreetName streetName = repo.findById(id);
        repo.delete(streetName);
        StreetName deletedStreetName = repo.findById(id);
        Assert.assertNull(deletedStreetName);
    }
}
