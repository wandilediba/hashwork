package hashwork.factories.ui.demographics;

import hashwork.domain.ui.demographics.GenderList;
import hashwork.repository.ui.demographics.GenderListRepository;
import hashwork.repository.ui.demographics.Impl.GenderListRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by hashcode on 2015/08/24.
 */
public class GenderListTest {
    private GenderListRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new GenderListRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        GenderList gender1 = GenderListFactory.getGenderList("Female");

        id = gender1.getId();
        System.out.println(" Gender 1 " + gender1.getId());
        repo.save(gender1);
        Assert.assertNotNull(gender1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        GenderList genderList = repo.findById(id);
        Assert.assertNotNull(genderList);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        GenderList genderList = repo.findById(id);
        GenderList newGenderList = new GenderList.Builder().copy(genderList).gender("TEST").build();
        repo.update(newGenderList);
        GenderList updatedGenderList = repo.findById(id);
        Assert.assertEquals("TEST", updatedGenderList.getGender());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        GenderList genderList = repo.findById(id);
        repo.delete(genderList);
        GenderList deletedGenderList = repo.findById(id);
        Assert.assertNull(deletedGenderList);
    }
}
