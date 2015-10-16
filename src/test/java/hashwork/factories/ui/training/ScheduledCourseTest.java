package hashwork.factories.ui.training;

import hashwork.domain.ui.training.ScheduledCourse;
import hashwork.repository.ui.training.Impl.ScheduledCourseRepositoryImpl;
import hashwork.repository.ui.training.ScheduledCourseRepository;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by sihle on 2015/10/15.
 */
public class ScheduledCourseTest {
    private ScheduledCourseRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new ScheduledCourseRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        List<String> courseRequestorIDs = new ArrayList<>();
        courseRequestorIDs.add("9900");
        courseRequestorIDs.add("9911");
        /*list of funderIds*/
        List<String> funderIds = new ArrayList<>();
        funderIds.add("8800");
        funderIds.add("8811");
        /*Set of participants*/
        Set<String> participants = new HashSet<>();
        participants.add("Jerry");
        ScheduledCourse scheduledCourse = ScheduledCourseFactory.getScheduledCourse(200, 180, new Date(), new Date(),
                new Date(), "12345", "LAB4", "OPEN", courseRequestorIDs,funderIds, participants);
        id = scheduledCourse.getId();
        repo.save(scheduledCourse);

        Assert.assertEquals(scheduledCourse.getNumOfStuds(), 180);
        Assert.assertNotNull(scheduledCourse);
        Assert.assertTrue(scheduledCourse.getParticipants().contains("Jerry"));
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        ScheduledCourse course = repo.findById(id);

        Assert.assertNotNull(course);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        ScheduledCourse course = repo.findById(id);
        ScheduledCourse toUpdate = new ScheduledCourse.Builder().copy(course)
                .courseCapacity(220)
                .numOfStuds(200)
                .build();
        repo.update(toUpdate);
        ScheduledCourse updated = repo.findById(id);

        Assert.assertEquals(updated.getNumOfStuds(), 200);
        Assert.assertEquals(updated.getCourseCapacity(), 220);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        ScheduledCourse course = repo.findById(id);
        repo.delete(course);
        ScheduledCourse deleted = repo.findById(id);

        Assert.assertNull(deleted);
    }
}
