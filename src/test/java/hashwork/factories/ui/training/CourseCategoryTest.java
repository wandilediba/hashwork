package hashwork.factories.ui.training;

import hashwork.domain.ui.training.CourseCategory;
import hashwork.factories.ui.training.CourseCategoryFactory;
import hashwork.repository.ui.training.CourseCategoryRepository;
import hashwork.repository.ui.training.Impl.CourseCategoryRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/13.
 */
public class CourseCategoryTest {
    private CourseCategoryRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new CourseCategoryRepositoryImpl();
    }

    @Test
    public void create() throws Exception{
        CourseCategory category  = CourseCategoryFactory.getCourseCategory("Science");
        id  = category.getId();
        repo.save(category);

        Assert.assertEquals(category.getCategoryName(), "Science");
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        CourseCategory cat = repo.findById(id);
        Assert.assertNotNull(cat);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        CourseCategory cat = repo.findById(id);
        CourseCategory update = new CourseCategory.Builder().copy(cat)
                .categoryName("Science and Technology")
                .build();
        repo.save(update);
        CourseCategory updateCat = repo.findById(id);

        Assert.assertEquals(updateCat.getCategoryName(),"Science and Technology");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        CourseCategory cat = repo.findById(id);
        repo.delete(cat);

        CourseCategory deleted = repo.findById(id);
        Assert.assertNull(deleted);
    }
}
