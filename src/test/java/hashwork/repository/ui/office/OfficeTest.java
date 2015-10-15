package hashwork.repository.ui.office;
import hashwork.domain.office.Office;
import hashwork.factories.office.OfficeFactory;
import hashwork.repository.office.Impl.OfficeRepositoryImpl;
import hashwork.repository.office.OfficeRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.Set;
import org.testng.Assert;
import hashwork.app.conf.Connection;

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
        Set<String> setTest = new HashSet<String>();
        Office office1 = OfficeFactory.getOffice("1", "test1", "description 1", "true", date, "1", "1", "1", setTest);
        Office office2 = OfficeFactory.getOffice("2", "test2", "description 2", "true", date, "2", "2", "2", setTest);
        Office office3 = OfficeFactory.getOffice("3", "test3", "description 3", "true", date, "3", "3", "3", setTest);
        id = office1.getId();
        System.out.println(" office 1 " + office1.getId());
        System.out.println(" office 2 " + office2.getId());
        System.out.println(" office 3 " + office3);
        repo.save(office1);
        Assert.assertNotNull(office1.getId());
    }
}
