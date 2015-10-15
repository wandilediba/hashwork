package hashwork.factories.ui.training;

import hashwork.domain.ui.training.CourseFundingSource;
import hashwork.factories.ui.training.CourseFundingSourceFactory;
import hashwork.repository.ui.training.CourseFundingSourceRepository;
import hashwork.repository.ui.training.Impl.CourseFundingSourceRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * Created by sihle on 2015/10/13.
 */
public class CourseFundingSourceTest {
    private CourseFundingSourceRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new CourseFundingSourceRepositoryImpl();
        //CourseFundingSource getCourseFundingSource(String courseId, String funderId, BigDecimal amount, String currencyId
    }
    @Test
    public void create() throws Exception{
        CourseFundingSource source = CourseFundingSourceFactory.getCourseFundingSource("12345", "67890",
                new BigDecimal(10100.00), "$");
        id = source.getId();
        repo.save(source);

        Assert.assertEquals(source.getCourseId(),"12345");
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        CourseFundingSource fundingSource = repo.findById(id);
        Assert.assertNotNull(fundingSource);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        CourseFundingSource fundingSource = repo.findById(id);
        CourseFundingSource update = new CourseFundingSource.Builder().copy(fundingSource)
                .currencyId("09876")
                .build();
        repo.update(update);
        CourseFundingSource updatedObject = repo.findById(id);
        Assert.assertEquals(updatedObject.getCurrencyId(), "09876");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        CourseFundingSource deleteSource = repo.findById(id);
        repo.delete(deleteSource);
        CourseFundingSource deleted = repo.findById(id);

        Assert.assertNull(deleted);
    }
}
