package hashwork.factories.ui.demographics;

import hashwork.domain.ui.demographics.RaceList;
import hashwork.repository.ui.demographics.Impl.RaceListRespositoryImpl;
import hashwork.repository.ui.demographics.RaceListRespository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by hashcode on 2015/08/24.
 */
public class RaceListTest {
    private RaceListRespository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new RaceListRespositoryImpl();
    }

    @Test
    public void create() throws Exception {
        RaceList race = RaceListFactory.getRaceList("Race");
        id = race.getId();
        System.out.println(" Race " + race.getId());
        repo.save(race);
        Assert.assertNotNull(race.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        RaceList raceList = repo.findById(id);
        Assert.assertNotNull(raceList);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        RaceList raceList = repo.findById(id);
        RaceList newRaceList = new RaceList.Builder().copy(raceList).raceName("TEST").build();
        repo.update(newRaceList);
        RaceList updatedRaceList = repo.findById(id);
        Assert.assertEquals("TEST", updatedRaceList.getRaceName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        RaceList raceList = repo.findById(id);
        repo.delete(raceList);
        RaceList deletedRaceList = repo.findById(id);
        Assert.assertNull(deletedRaceList);
    }
}
