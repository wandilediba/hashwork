package hashwork.factories.ui.Country;

import hashwork.domain.ui.country.Country;
import hashwork.factories.ui.country.CountryFactory;
import hashwork.repository.ui.country.CountryRepository;
import hashwork.repository.ui.country.Impl.CountryRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by garran on 2015/09/05.
 */
public class CountryTest {
    private CountryRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new CountryRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Country country1 = CountryFactory.getCountry("South Africa");
        Country country2 = CountryFactory.getCountry("Chad");
        id = country1.getId();
        System.out.println(" City 1 " + country1.getId());
        System.out.println(" City 3 " + country2);
        repo.save(country1);
        Assert.assertNotNull(country1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Country country = repo.findById(id);
        Assert.assertNotNull(country);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Country country = repo.findById(id);
        Country newCountry = new Country.Builder().copy(country).country("South Africa").build();
        repo.update(newCountry);
        Country updatedCountry = repo.findById(id);
        Assert.assertEquals("South Africa", updatedCountry.getCountry());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Country country = repo.findById(id);
        repo.delete(country);
        Country deletedCountry = repo.findById(id);
        Assert.assertNull(deletedCountry);
    }
}
