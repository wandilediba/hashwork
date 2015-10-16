package hashwork.factories.ui.training;

import hashwork.domain.ui.training.CourseRequest;
import hashwork.repository.ui.training.CourseRequestRepository;
import hashwork.repository.ui.training.Impl.CourseRequestRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sihle on 2015/10/15.
 */
public class CourseRequestTest {
    private CourseRequestRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new CourseRequestRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        /*list of requestorIDs*/
        List<String> requestorIDs = new ArrayList<>();
        requestorIDs.add("2345");
        requestorIDs.add("1234");
        /*list of competencies Ids*/
        List<String> competenciesIds = new ArrayList<>();
        competenciesIds.add("9900");
        competenciesIds.add("9911");
        /*list of funderIds*/
        List<String> funderIds = new ArrayList<>();
        funderIds.add("8800");
        funderIds.add("8811");
        /*list of trainingInstitutions Ids*/
        List<String> trainingInstitutionsId = new ArrayList<>();
        trainingInstitutionsId.add("7700");
        trainingInstitutionsId.add("7711");

        CourseRequest courseRequest = CourseRequestFactory.getCourseRequest("Base Topic", requestorIDs,
                competenciesIds, new Date(), new Date(),new Date(),
                funderIds, trainingInstitutionsId, "REJECTED" );
        id = courseRequest.getId();
        repo.save(courseRequest);

        Assert.assertNotNull(courseRequest);
        Assert.assertEquals(courseRequest.getFunderIds().size(), 2);
        Assert.assertEquals(courseRequest.getStatus(), "REJECTED");
        Assert.assertTrue(courseRequest.getRequestorsIds().contains("1234"));
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        CourseRequest request = repo.findById(id);

        Assert.assertNotNull(request);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        CourseRequest request = repo.findById(id);
        CourseRequest toUpdate = new CourseRequest.Builder().copy(request)
                .status("ACCEPTED")
                .requestName("Bribe Base")
                .build();
        repo.update(toUpdate);
        CourseRequest updated = repo.findById(id);

        Assert.assertEquals(updated.getRequestName(), "Bribe Base");
        Assert.assertEquals(updated.getStatus(), "ACCEPTED");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        CourseRequest request = repo.findById(id);
        repo.delete(request);
        CourseRequest deleted = repo.findById(id);

        Assert.assertNull(deleted);
    }
}