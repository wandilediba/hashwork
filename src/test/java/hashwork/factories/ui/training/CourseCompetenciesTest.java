package hashwork.factories.ui.training;

import hashwork.domain.ui.training.CourseCompetencies;
import hashwork.factories.ui.training.CourseCompetenciesFactory;
import hashwork.repository.ui.training.CourseCompetenciesRepository;
import hashwork.repository.ui.training.Impl.CourseCompetenciesRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/13.
 */
public class CourseCompetenciesTest {
    private CourseCompetenciesRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new CourseCompetenciesRepositoryImpl();
    }

    @Test
    public void create() throws Exception{
        CourseCompetencies courseComp = CourseCompetenciesFactory.getCourseCompetencies("12345678",
                "20202020202020");
        id = courseComp.getId();
        repo.save(courseComp);
        Assert.assertEquals(courseComp.getCompetencyId(), "20202020202020");
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        CourseCompetencies co = repo.findById(id);
        Assert.assertNotNull(co);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        CourseCompetencies course = repo.findById(id);
        CourseCompetencies updateObj = new CourseCompetencies.Builder().copy(course)
                .competencyid("303030303030")
                .build();
        repo.update(updateObj);

        CourseCompetencies updatedCourse = repo.findById(id);
        Assert.assertEquals(updatedCourse.getCompetencyId(),"303030303030");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        CourseCompetencies deleteItem = repo.findById(id);
        repo.delete(deleteItem);
        CourseCompetencies deleted = repo.findById(id);
        Assert.assertNull(deleted);
    }
}
