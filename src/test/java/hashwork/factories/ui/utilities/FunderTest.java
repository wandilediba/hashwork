/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.utilities;

import hashwork.domain.ui.util.Funder;
import hashwork.factories.ui.util.FunderFactory;
import hashwork.repository.ui.utililties.FunderRepository;
import hashwork.repository.ui.utililties.Impl.FunderRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author bulelani
 */
public class FunderTest {
    private FunderRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new FunderRepositoryImpl();
    }
    @Test
    public void create() throws Exception {
        Funder funder = FunderFactory.getFunder("Name", "Center", "City", "Location");
        Funder funder2 = FunderFactory.getFunder("Name2", "Center2", "City2", "Location2");
        Funder funder3 = FunderFactory.getFunder("Name3", "Center3", "City3", "Location3");
        id = funder.getId();
        System.out.println(" Funder 1 " + funder.getId());
        System.out.println(" Funder 2" + funder2.getId());
        System.out.println(" Funder 3 " + funder3);
        repo.save(funder);
        Assert.assertNotNull(funder.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Funder funder = repo.findById(id);
        Assert.assertNotNull(funder);
    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Funder funder = repo.findById(id);
        Funder newFunder = new Funder.Builder().copy(funder).trainingFunderName("TEST").build();
        repo.update(newFunder);
        Funder updatedFunder = repo.findById(id);
        Assert.assertEquals("TEST", updatedFunder.getTrainingFunderName());
    }
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Funder funder = repo.findById(id);
        repo.delete(funder);
        Funder deletedFunder = repo.findById(id);
        Assert.assertNull(deletedFunder);
    }
}

