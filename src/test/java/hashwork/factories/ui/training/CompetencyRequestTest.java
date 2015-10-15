package hashwork.factories.ui.training;

import hashwork.domain.ui.training.CompetencyRequest;
import hashwork.factories.ui.training.CompetencyRequestFactory;
import hashwork.repository.ui.training.CompetencyRequestRepository;
import hashwork.repository.ui.training.Impl.CompetencyRequestRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by sihle on 2015/10/13.
 */
public class CompetencyRequestTest {
    private CompetencyRequestRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new CompetencyRequestRepositoryImpl();
    }

    @Test
    public void create() throws Exception{
        CompetencyRequest request = CompetencyRequestFactory.getCompetencyRequest("Running","1101101010101010",
                new Date(),"Sihle", "1234539", "REJECTED", "Too Dull");
        id = request.getId();
        repo.save(request);

        Assert.assertNotNull(request);
        Assert.assertEquals(request.getStatus(), "REJECTED");
        Assert.assertEquals(request.getRequestorName(),"Sihle");
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        CompetencyRequest req = repo.findById(id);
        Assert.assertNotNull(req);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        CompetencyRequest req = repo.findById(id);
        CompetencyRequest update = new CompetencyRequest.Builder().copy(req)
                .requestorName("Zenzile")
                .build();
        repo.update(update);

        CompetencyRequest updatedReq = repo.findById(id);
        Assert.assertEquals(updatedReq.getRequestorName(), "Zenzile");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        CompetencyRequest deleteReq = repo.findById(id);
        repo.delete(deleteReq);

        CompetencyRequest deletedRequest = repo.findById(id);
        Assert.assertNull(deletedRequest);
    }
}
