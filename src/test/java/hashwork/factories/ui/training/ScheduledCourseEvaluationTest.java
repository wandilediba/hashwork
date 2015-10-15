package hashwork.factories.ui.training;

import hashwork.domain.ui.training.ScheduledCourseEvaluation;
import hashwork.repository.ui.training.Impl.ScheduledCourseEvaluationRepositoryImpl;
import hashwork.repository.ui.training.ScheduledCourseEvaluationRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/15.
 */
public class ScheduledCourseEvaluationTest {
    private ScheduledCourseEvaluationRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new ScheduledCourseEvaluationRepositoryImpl();
    }

    @Test
    public void create() throws Exception {


        //(String scheduledCourseId, int rating, String comments
        ScheduledCourseEvaluation courseEvaluation = ScheduledCourseEvaluationFactory.getScheduledCourseEvaluation("11111",
                4, "Very Low");
        id = courseEvaluation.getId();
        repo.save(courseEvaluation);

        Assert.assertEquals(courseEvaluation.getRating(), 4);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        ScheduledCourseEvaluation courseEvaluation = repo.findById(id);

        Assert.assertNotNull(courseEvaluation);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        ScheduledCourseEvaluation courseEvaluation = repo.findById(id);
        ScheduledCourseEvaluation toBeUpdated = new ScheduledCourseEvaluation.Builder().copy(courseEvaluation)
                .comments("Improve")
                .build();
        repo.update(toBeUpdated);
        ScheduledCourseEvaluation updatedCourse = repo.findById(id);
        Assert.assertEquals(updatedCourse.getComments(), "Improve");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        ScheduledCourseEvaluation course = repo.findById(id);
        repo.delete(course);
        ScheduledCourseEvaluation deletedItem = repo.findById(id);
        Assert.assertNull(deletedItem);
    }
}
