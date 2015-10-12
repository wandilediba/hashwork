package hashwork.repository.ui.office;
import hashwork.domain.office.Department;
import hashwork.repository.office.DepartmentRepository;
import hashwork.repository.office.Impl.DepartmentRepositoryImpl;
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
public class DepartmentTest {
    private DepartmentRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = new DepartmentRepositoryImpl();
    }

    @Test
    public void readAll() throws Exception {

        Redisson redisson = Connection.getConnection();
        RMap<String, Department> map = redisson.getMap("department");

        Set<Department> department = repository.findAll();

        final Predicate<Department> notNull = loca -> loca.getId() != null;

        final Predicate<Department> startsWithN = location -> location.getId().equalsIgnoreCase("f5c3f4bf-e77e-4024-be5e-1af9c39dc0ef");

        long count = department.stream().parallel().filter(notNull).filter(startsWithN).count();

        System.out.println("The Count is " + count);
        Assert.assertTrue(count > 0);
    }
}
