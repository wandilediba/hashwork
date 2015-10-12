package hashwork.repository.ui.office;

import hashwork.domain.office.Company;
import hashwork.repository.office.CompanyRepository;
import hashwork.repository.office.Impl.CompanyRepositoryImpl;
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
public class CompanyTest {
    private CompanyRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = new CompanyRepositoryImpl();
    }

    @Test
    public void readAll() throws Exception {

        Redisson redisson = Connection.getConnection();
        RMap<String, Company> map = redisson.getMap("company");

        Set<Company> locations = repository.findAll();

        final Predicate<Company> notNull = loca -> loca.getId() != null;

        final Predicate<Company> startsWithN = location -> location.getId().equalsIgnoreCase("f5c3f4bf-e77e-4024-be5e-1af9c39dc0ef");

        long count = locations.stream().parallel().filter(notNull).filter(startsWithN).count();

        System.out.println("The Count is " + count);
        Assert.assertTrue(count > 0);
    }
}
