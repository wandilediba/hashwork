package hashwork.repository.ui.office;
import hashwork.domain.office.Department;
import hashwork.factories.office.DepartmentFactory;
import hashwork.repository.office.DepartmentRepository;
import hashwork.repository.office.Impl.DepartmentRepositoryImpl;
import org.redisson.Redisson;
import org.redisson.core.RMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.function.Predicate;
import java.util.Set;
import org.testng.Assert;
import hashwork.app.conf.Connection;

/**
 * Created by garran on 2015/10/12.
 */
public class DepartmentTest {
    private DepartmentRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new DepartmentRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Date date = new Date();
        Department department1 = DepartmentFactory.getDepartment("1", "test1", date, true, "This is a test1");
        Department department2 = DepartmentFactory.getDepartment("2", "test2", date, true, "This is a test2");
        Department department3 = DepartmentFactory.getDepartment("3", "test3", date, true, "This is a test3");
        id = department1.getId();
        System.out.println(" department 1 " + department1.getId());
        System.out.println(" department 2 " + department2.getId());
        System.out.println(" department 3 " + department3);
        repo.save(department1);
        Assert.assertNotNull(department1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Department department = repo.findById(id);
        Assert.assertNotNull(department);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Department department = repo.findById(id);
        Department newDepartment = new Department.Builder().copy(department).name("test1").build();
        repo.update(newDepartment);
        Department updatedCompany = repo.findById(id);
        Assert.assertEquals("test1", updatedCompany.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Department department = repo.findById(id);
        repo.delete(department);
        Department deletedCompany = repo.findById(id);
        Assert.assertNull(deletedCompany);
    }
}
