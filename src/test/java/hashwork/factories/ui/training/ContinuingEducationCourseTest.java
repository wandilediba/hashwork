package hashwork.factories.ui.training;

import hashwork.domain.ui.training.ContinuingEducationCourse;
import hashwork.factories.ui.training.ContinuingEducationCourseFactory;
import hashwork.repository.ui.training.ContinuingEducationCourseRepository;
import hashwork.repository.ui.training.Impl.ContinuingEducationCourseRespositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/13.
 */
public class ContinuingEducationCourseTest {
    private ContinuingEducationCourseRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new ContinuingEducationCourseRespositoryImpl();
        //String courseName, int creditHours)
    }

    @Test
    public void create() throws Exception{
        ContinuingEducationCourse contEduCourse = ContinuingEducationCourseFactory.getContinuingEducationCourse(
                "Information Technology", 45);
        id = contEduCourse.getId();
        repo.save(contEduCourse);

        Assert.assertEquals(contEduCourse.getCreditHours(), 45);
        Assert.assertNotNull(contEduCourse);
        Assert.assertEquals(contEduCourse.getCourseName(), "Information Technology");
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        ContinuingEducationCourse course = repo.findById(id);
        Assert.assertNotNull(course);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        ContinuingEducationCourse course = repo.findById(id);
        ContinuingEducationCourse update = new ContinuingEducationCourse.Builder().copy(course)
                .creditHours(57)
                .build();
        repo.update(update);
        ContinuingEducationCourse updated = repo.findById(id);

        Assert.assertEquals(updated.getCreditHours(), 57);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        ContinuingEducationCourse deleteCourse = repo.findById(id);
        repo.delete(deleteCourse);
        ContinuingEducationCourse deleted = repo.findById(id);

        Assert.assertNull(deleted);
    }
}
