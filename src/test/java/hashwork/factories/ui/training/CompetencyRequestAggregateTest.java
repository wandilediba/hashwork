package hashwork.factories.ui.training;

import hashwork.domain.ui.training.CompetencyRequestAggregate;
import hashwork.factories.ui.training.CompetencyRequestAggregateFactory;
import hashwork.repository.ui.training.CompetencyRequestAggregateRepository;
import hashwork.repository.ui.training.Impl.CompetencyRequestAggregateRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sihle on 2015/10/13.
 */
public class CompetencyRequestAggregateTest {
    private CompetencyRequestAggregateRepository repo;
    private String id;

    @BeforeMethod
    public void setUp()
    {
        repo = new CompetencyRequestAggregateRepositoryImpl();
    }

    @Test
    public void create() throws Exception{
        CompetencyRequestAggregate aggregate = CompetencyRequestAggregateFactory.getCompetencyRequestAggregate("Dance", "REJECTED", 3);
        id = aggregate.getId();

        repo.save(aggregate);

        Assert.assertNotNull(aggregate);
        Assert.assertEquals(aggregate.getCount(), 3);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        CompetencyRequestAggregate reqAggr = repo.findById(id);
        Assert.assertNotNull(reqAggr);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        CompetencyRequestAggregate toBeUpdated = repo.findById(id);
        CompetencyRequestAggregate newAgg = new CompetencyRequestAggregate.Builder().copy(toBeUpdated)
                .count(4)
                .build();
        repo.update(newAgg);
        CompetencyRequestAggregate updated = repo.findById(id);

        Assert.assertEquals(updated.getCount(), 4);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{

    }
}
