package hashwork.factories.ui.training;

import hashwork.domain.ui.training.TrainingInstitutionTrainer;
import hashwork.repository.ui.training.Impl.TrainingInstitutionTrainerRepositoryImpl;
import hashwork.repository.ui.training.TrainingInstitutionTrainerRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/16.
 */
public class TrainingInstitutionTrainerTest {
    private TrainingInstitutionTrainerRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new TrainingInstitutionTrainerRepositoryImpl();
    }
//String title, String firstName, String lastName, String qualification)
    @Test
    public void create() throws Exception {
        TrainingInstitutionTrainer trainer = TrainingInstitutionTrainerFactory.getTrainingInstitutionTrainer("Mr",
                "Sihle", "Zenzile", "Diploma");
        id = trainer.getId();
        repo.save(trainer);

        Assert.assertEquals(trainer.getFirstName(), "Sihle");
        Assert.assertEquals(trainer.getQualification(), "Diploma");
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        TrainingInstitutionTrainer trainer = repo.findById(id);

        Assert.assertNotNull(trainer);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        TrainingInstitutionTrainer trainer = repo.findById(id);
        TrainingInstitutionTrainer toBeUpdated = new TrainingInstitutionTrainer.Builder().copy(trainer)
                .title("Dr")
                .qualification("PhD")
                .build();
        repo.update(toBeUpdated);
        TrainingInstitutionTrainer updated = repo.findById(id);

        Assert.assertEquals(updated.getQualification(), "PhD");
        Assert.assertEquals(updated.getTitle(), "Dr");

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        TrainingInstitutionTrainer trainer = repo.findById(id);
        repo.delete(trainer);
        TrainingInstitutionTrainer deleted = repo.findById(id);

        Assert.assertNull(deleted);
    }
}
