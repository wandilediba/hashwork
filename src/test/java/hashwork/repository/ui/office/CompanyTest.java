package hashwork.repository.ui.office;

import hashwork.domain.office.Company;
import hashwork.factories.office.CompanyFactory;
import hashwork.repository.office.CompanyRepository;
import hashwork.repository.office.Impl.CompanyRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by garran on 2015/10/12.
 */
public class CompanyTest {
    private CompanyRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new CompanyRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Company company1 = CompanyFactory.getCompany("test1");
        Company company2 = CompanyFactory.getCompany("test2");
        Company company3 = CompanyFactory.getCompany("test3");
        id = company1.getId();
        System.out.println(" company 1 " + company1.getId());
        System.out.println(" company 2 " + company2.getId());
        System.out.println(" company 3 " + company3);
        repo.save(company1);
        Assert.assertNotNull(company1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Company company = repo.findById(id);
        Assert.assertNotNull(company);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Company company = repo.findById(id);
        Company newCompany = new Company.Builder().copy(company).name("test1").build();
        repo.update(newCompany);
        Company updatedCompany = repo.findById(id);
        Assert.assertEquals("test1", updatedCompany.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Company company = repo.findById(id);
        repo.delete(company);
        Company deletedCompany = repo.findById(id);
        Assert.assertNull(deletedCompany);
    }
}
