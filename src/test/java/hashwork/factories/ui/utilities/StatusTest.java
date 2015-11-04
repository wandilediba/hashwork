/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.utilities;

import hashwork.domain.ui.util.Status;
import hashwork.factories.ui.util.StatusFactory;
import hashwork.repository.ui.utililties.Impl.StatusRepositoryImpl;
import hashwork.repository.ui.utililties.StatusRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author bulelani
 */
public class StatusTest {
    private StatusRepository repo;
    private String id;
    @BeforeMethod
    public void setUp() throws Exception {
        repo = new StatusRepositoryImpl();
    }
    @Test
    public void create() throws Exception {
        Status status = StatusFactory.getStatus("Value","Type");
        Status status2 = StatusFactory.getStatus("Value2", "Type2");
        Status status3 = StatusFactory.getStatus("Value3", "Value3");
        id = status.getId();
        System.out.println(" Status 1 " + status.getId());
        System.out.println(" Status 2" + status2.getId());
        System.out.println(" Status 3 " + status3);
        repo.save(status);
        Assert.assertNotNull(status.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Status status = repo.findById(id);
        Assert.assertNotNull(status);
    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Status status = repo.findById(id);
        Status newStatus = new Status.Builder().copy(status).statusType("TEST").build();
        repo.update(newStatus);
        Status updatedStatus = repo.findById(id);
        Assert.assertEquals("TEST", updatedStatus.getStatusType());
    }
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Status status = repo.findById(id);
        repo.delete(status);
        Status deletedStatus = repo.findById(id);
        Assert.assertNull(deletedStatus);
    }
}
