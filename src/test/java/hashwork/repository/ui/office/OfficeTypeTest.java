package hashwork.repository.ui.office;
import hashwork.domain.office.OfficeType;
import hashwork.repository.office.Impl.OfficeTypeRepositoryImpl;
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
    private OfficeTypeRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = new OfficeTypeRepositoryImpl();
    }

    @Test
    public void readAll() throws Exception {

        Redisson redisson = Connection.getConnection();
        RMap<String, OfficeType> map = redisson.getMap("officetype");

        Set<OfficeType> officeType = repository.findAll();

        final Predicate<OfficeType> notNull = loca -> loca.getId() != null;

        final Predicate<OfficeType> startsWithN = location -> location.getId().equalsIgnoreCase("f5c3f4bf-e77e-4024-be5e-1af9c39dc0ef");

        long count = officeType.stream().parallel().filter(notNull).filter(startsWithN).count();

        System.out.println("The Count is " + count);
        Assert.assertTrue(count > 0);
    }
}
