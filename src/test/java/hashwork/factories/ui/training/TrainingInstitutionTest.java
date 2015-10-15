package hashwork.factories.ui.training;

import hashwork.domain.ui.training.TrainingInstitution;
import hashwork.repository.ui.training.Impl.TrainingInstitutionRepositoryImpl;
import hashwork.repository.ui.training.TrainingInstitutionRepositpry;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/15.
 */
public class TrainingInstitutionTest {
    private TrainingInstitutionRepositpry repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new TrainingInstitutionRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        TrainingInstitution institution = TrainingInstitutionFactory.getTrainingInstitution("CPUT", "Cape Town",
                "info@cput.ac.za");
        id = institution.getId();
        repo.save(institution);

        Assert.assertEquals(institution.getLocationContact(), "info@cput.ac.za");
        Assert.assertNotNull(institution);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        TrainingInstitution institution = repo.findById(id);

        Assert.assertNotNull(institution);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        TrainingInstitution institution = repo.findById(id);
        TrainingInstitution toBeUpdated = new TrainingInstitution.Builder().copy(institution)
                .locationContact("cput@cput.ac.za")
                .build();
        repo.update(toBeUpdated);
        TrainingInstitution updated = repo.findById(id);

        Assert.assertEquals(updated.getLocationContact(), "cput@cput.ac.za");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        TrainingInstitution institution = repo.findById(id);
        repo.delete(institution);
        TrainingInstitution deleted = repo.findById(id);

        Assert.assertNull(deleted);
    }
}
