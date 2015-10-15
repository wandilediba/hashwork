package hashwork.factories.ui.demographics;

import hashwork.domain.ui.demographics.TitleList;
import hashwork.repository.ui.demographics.Impl.TitleListRespositoryImpl;
import hashwork.repository.ui.demographics.TitleListRespository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by hashcode on 2015/08/24.
 */
public class TitleListTest {
    private TitleListRespository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new TitleListRespositoryImpl();
    }

    @Test
    public void create() throws Exception {
        TitleList titleList = TitleListFactory.getTitleList("A Title");
        id = titleList.getId();
        System.out.println(" Title " + titleList.getId());
        repo.save(titleList);
        Assert.assertNotNull(titleList.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        TitleList titleList = repo.findById(id);
        Assert.assertNotNull(titleList);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        TitleList titleList = repo.findById(id);
        TitleList newTitleList = new TitleList.Builder().copy(titleList).title("TEST").build();
        repo.update(newTitleList);
        TitleList updatedTitleList = repo.findById(id);
        Assert.assertEquals("TEST", updatedTitleList.getTitle());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        TitleList titleList = repo.findById(id);
        repo.delete(titleList);
        TitleList deletedTitleList = repo.findById(id);
        Assert.assertNull(deletedTitleList);
    }
}
