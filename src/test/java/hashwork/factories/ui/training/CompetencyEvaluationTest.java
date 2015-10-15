package hashwork.factories.ui.training;

import hashwork.domain.ui.training.CompetencyEvaluation;
import hashwork.factories.ui.training.CompetencyEvaluationFactory;
import hashwork.repository.ui.training.CompetencyEvaluationRepository;
import hashwork.repository.ui.training.Impl.CompetencyEvaluationRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/13.
 */
public class CompetencyEvaluationTest {
    private CompetencyEvaluationRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception{
        repo = new CompetencyEvaluationRepositoryImpl();
    }

    @Test
    public void create() throws Exception{
        CompetencyEvaluation competencyEv1 = CompetencyEvaluationFactory.getCompetencyEvaluation("Running",
                "Running with eyes closed");
        CompetencyEvaluation competencyEv2 = CompetencyEvaluationFactory.getCompetencyEvaluation("Typing",
                "Typing 60 words per minute");
        id = competencyEv1.getId();
        repo.save(competencyEv1);
        Assert.assertEquals(competencyEv1.getId(), "Running with eyes closed");
        Assert.assertNotNull(competencyEv1.getId());
    }

    @Test(dependsOnMethods="create")
    public void read() throws Exception{
        CompetencyEvaluation competencyEv1 = repo.findById(id);
        Assert.assertNotNull(competencyEv1);
    }

    @Test(dependsOnMethods="read")
    public void update() throws Exception{
        CompetencyEvaluation competencyEv1 = repo.findById(id);
        CompetencyEvaluation updateCompetencyEv = new CompetencyEvaluation.Builder()
                .copy(competencyEv1)
                .compType("Dance")
                .build();
        repo.update(updateCompetencyEv);

        CompetencyEvaluation updatedCompEv = repo.findById(id);
        Assert.assertEquals(updatedCompEv.getId(), "Running with eyes closed");

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        CompetencyEvaluation competencyEv1 = repo.findById(id);
        repo.delete(competencyEv1);
        CompetencyEvaluation deleted = repo.findById(id);
        Assert.assertNull(deleted);
    }
}
