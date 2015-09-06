package hashwork.repository.ui.address;

import hashwork.domain.ui.address.Suburb;
import hashwork.factories.ui.address.SuburbFactory;
import hashwork.repository.ui.address.Impl.SuburbRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by garran on 2015/08/30.
 */
public class SuburbTest {
    private SuburbRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new SuburbRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Suburb suburb1 = SuburbFactory.getSuburb("Muizenberg");
        Suburb suburb2 = SuburbFactory.getSuburb("Fish Hoek");
        Suburb suburb3 = SuburbFactory.getSuburb("Newlands");
        id = suburb1.getId();
        System.out.println(" Suburb 1 " + suburb1.getId());
        System.out.println(" Suburb 2 " + suburb2.getId());
        System.out.println(" Suburb 3 " + suburb3);
        repo.save(suburb1);
        Assert.assertNotNull(suburb1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Suburb suburb = repo.findById(id);
        Assert.assertNotNull(suburb);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Suburb suburb = repo.findById(id);
        Suburb newSuburb = new Suburb.Builder().copy(suburb).suburb("TEST").build();
        repo.update(newSuburb);
        Suburb updatedSuburb = repo.findById(id);
        Assert.assertEquals("TEST", updatedSuburb.getSuburb());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Suburb suburb = repo.findById(id);
        repo.delete(suburb);
        Suburb deletedSuburb = repo.findById(id);
        Assert.assertNull(deletedSuburb);


    }
}
