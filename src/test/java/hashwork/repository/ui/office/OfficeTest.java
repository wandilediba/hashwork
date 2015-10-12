package hashwork.repository.ui.office;
import hashwork.domain.office.Office;
import hashwork.repository.office.Impl.OfficeRepositoryImpl;
import hashwork.repository.office.OfficeRepository;
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
public class OfficeTest {
    private OfficeRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = new OfficeRepositoryImpl();
    }

    @Test
    public void readAll() throws Exception {

        Redisson redisson = Connection.getConnection();
        RMap<String, Office> map = redisson.getMap("company");

        Set<Office> office = repository.findAll();

        final Predicate<Office> notNull = loca -> loca.getId() != null;

        final Predicate<Office> startsWithN = location -> location.getId().equalsIgnoreCase("f5c3f4bf-e77e-4024-be5e-1af9c39dc0ef");

        long count = office.stream().parallel().filter(notNull).filter(startsWithN).count();

        System.out.println("The Count is " + count);
        Assert.assertTrue(count > 0);
    }
}
