package hashwork.factories.ui.training;

import hashwork.domain.ui.training.ScheduledCourseInstructor;
import hashwork.repository.ui.training.Impl.ScheduledCourseInstructorRepositoryImpl;
import hashwork.repository.ui.training.ScheduledCourseInstructorRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/15.
 */
public class ScheduledCourseInstructorTest {
    private ScheduledCourseInstructorRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new ScheduledCourseInstructorRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        ScheduledCourseInstructor instructor = ScheduledCourseInstructorFactory.getScheduledCourseInstructor("12309",
                "99999");
        id = instructor.getId();
        repo.save(instructor);

        Assert.assertNotNull(instructor);
        Assert.assertEquals(instructor.getTrainerId(), "99999");
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        ScheduledCourseInstructor instructor = repo.findById(id);

        Assert.assertNotNull(instructor);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        ScheduledCourseInstructor instructor = repo.findById(id);
        ScheduledCourseInstructor inst = new ScheduledCourseInstructor.Builder().copy(instructor)
                .scheduledCourseId("77777")
                .build();
        repo.update(inst);
        ScheduledCourseInstructor updated = repo.findById(id);

        Assert.assertEquals(inst.getScheduledCourseId(), "77777");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        ScheduledCourseInstructor instructor = repo.findById(id);
        repo.delete(instructor);
        ScheduledCourseInstructor deleted = repo.findById(id);

        Assert.assertNull(deleted);
    }

}
