package hashwork.repository.ui.office;
import hashwork.domain.office.OfficeType;
import hashwork.factories.office.OfficeTypeFactory;
import hashwork.repository.office.Impl.OfficeRepositoryImpl;
import hashwork.repository.office.Impl.OfficeTypeRepositoryImpl;
import hashwork.repository.office.OfficeRepository;
import hashwork.repository.office.OfficeTypeRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.function.Predicate;
import java.util.Set;
import org.testng.Assert;
import hashwork.app.conf.Connection;

/**
 * Created by garran on 2015/10/12.
 */
public class OfficeTypeTest {
    private OfficeTypeRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new OfficeTypeRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        OfficeType officeType1 = OfficeTypeFactory.getOfficeType("1", "test1");
        OfficeType officeType2 = OfficeTypeFactory.getOfficeType("2", "test2");
        OfficeType officeType3 = OfficeTypeFactory.getOfficeType("3", "test3");
        id = officeType1.getId();
        System.out.println(" officeType 1 " + officeType1.getId());
        System.out.println(" officeType 2 " + officeType2.getId());
        System.out.println(" officeType 3 " + officeType3);
        repo.save(officeType1);
        Assert.assertNotNull(officeType1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        OfficeType officeType = repo.findById(id);
        Assert.assertNotNull(officeType);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        OfficeType officeType = repo.findById(id);
        OfficeType newOfficeType = new OfficeType.Builder().copy(officeType).name("test1").build();
        repo.update(newOfficeType);
        OfficeType updatedCompany = repo.findById(id);
        Assert.assertEquals("test1", updatedCompany.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        OfficeType officeType = repo.findById(id);
        repo.delete(officeType);
        OfficeType deletedOfficeType = repo.findById(id);
        Assert.assertNull(deletedOfficeType);
    }
}
