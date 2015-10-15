package hashwork.factories.ui.training;

import hashwork.domain.ui.training.Course;
import hashwork.factories.ui.training.CourseFactory;
import hashwork.repository.ui.training.CourseRepository;
import hashwork.repository.ui.training.Impl.CourseRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sihle on 2015/10/13.
 */
public class CourseTest {
    private CourseRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws  Exception{
        repo = new CourseRepositoryImpl();
    }
    @Test
    public void create() throws Exception{
        List<String> compId = new ArrayList<>();
        compId.add("00001");
        compId.add("00002");
        Course course = CourseFactory.getCourse("Public Relation", "1234", "Mass Communication",
                "101010", "444444", "Improve Lives Through Public Sphere", 74, compId);
        id = course.getId();
        repo.save(course);

        Assert.assertNotNull(course);
        Assert.assertEquals(course.getCreditHours(), 74);
        Assert.assertEquals(course.getCourseName(), "Public Relation");
        Assert.assertNotEquals(course.getCourseTopic(), "M Comm");
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        Course course = repo.findById(id);
        Assert.assertNotNull(course);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        Course course = repo.findById(id);
        Course updateCourse = new Course.Builder().copy(course)
                .courseName("Public Relation Add")
                .creditHours(88)
                .build();
        repo.update(updateCourse);
        Course updatedCourse = repo.findById(id);

        Assert.assertEquals(updatedCourse.getCourseName(),"Public Relation Add");
        Assert.assertEquals(updatedCourse.getCreditHours(), 88);
        Assert.assertNotEquals(updatedCourse.getCreditHours(), 74);

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        Course course = repo.findById(id);
        repo.delete(course);
        Course deletedCourse = repo.findById(id);

        Assert.assertNull(deletedCourse);
    }
}
