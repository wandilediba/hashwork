package hashwork.factories.ui.training;

import hashwork.domain.ui.training.ScheduledCourseRequestor;
import hashwork.repository.ui.training.Impl.ScheduledCourseRequestorRepositoryImpl;
import hashwork.repository.ui.training.ScheduledCourseRequestorRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/15.
 */
public class ScheduledCourseRequestorTest {
    private ScheduledCourseRequestorRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new ScheduledCourseRequestorRepositoryImpl();
    }
//getAddressType(String scheduledCourseId, String requesterId)
    @Test
    public void create() throws Exception {
        ScheduledCourseRequestor req = ScheduledCourseRequestorFactory.getAddressType("22221", "00001");
        id = req.getId();
        repo.save(req);

        Assert.assertEquals(req.getScheduledCourseId(), "22221");
        Assert.assertEquals(req.getRequesterId(), "00001");
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        ScheduledCourseRequestor req = repo.findById(id);

        Assert.assertNotNull(req);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        ScheduledCourseRequestor req = repo.findById(id);
        ScheduledCourseRequestor toBeUpdated = new ScheduledCourseRequestor.Builder().copy(req)
                .scheduledCourseId("33331")
                .build();
        repo.update(toBeUpdated);
        ScheduledCourseRequestor updated = repo.findById(id);

        Assert.assertEquals(updated.getScheduledCourseId(), "33331");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        ScheduledCourseRequestor requestor = repo.findById(id);
        repo.delete(requestor);
        ScheduledCourseRequestor deleted = repo.findById(id);

        Assert.assertNull(deleted);
    }
}
