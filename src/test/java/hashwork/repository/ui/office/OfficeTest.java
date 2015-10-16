package hashwork.repository.ui.office;
import hashwork.domain.office.Office;
import hashwork.factories.office.OfficeFactory;
import hashwork.repository.office.Impl.OfficeRepositoryImpl;
import hashwork.repository.office.OfficeRepository;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.*;

/**
 * Created by garran on 2015/10/12.
 */
public class OfficeTest {
    private OfficeRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new OfficeRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Date date = new Date();
        //Set<String> myset = myMap.keySet();
        List<String> stringList = new ArrayList<>();
        stringList.add("x");
        Map<String,String> values = new HashMap<String,String>();
        values.put("a","b");
        Set<String> setTest = new HashSet<String>();
        Office office1 = OfficeFactory.getOffice(values, date, stringList);
//        Office office2 = OfficeFactory.getOffice("test2", "description 2", "true", date, "2", "2", "2", setTest);
//        Office office3 = OfficeFactory.getOffice("test3", "description 3", "true", date, "3", "3", "3", setTest);
        id = office1.getId();
        System.out.println(" office 1 " + office1.getId());
//        System.out.println(" office 2 " + office2.getId());
//        System.out.println(" office 3 " + office3);
        repo.save(office1);
        Assert.assertNotNull(office1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Office office = repo.findById(id);
        Assert.assertNotNull(office);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Office office = repo.findById(id);
        Office newOffice = new Office.Builder().copy(office).name("test1").build();
        repo.update(newOffice);
        Office updatedCompany = repo.findById(id);
        Assert.assertEquals("test1", updatedCompany.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Office office = repo.findById(id);
        repo.delete(office);
        Office deletedCompany = repo.findById(id);
        Assert.assertNull(deletedCompany);
    }
}
