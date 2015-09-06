package hashwork.factories.ui.City;

import hashwork.domain.ui.City.City;
import hashwork.repository.ui.City.CityRepository;
import hashwork.repository.ui.City.Impl.CityRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by garran on 2015/09/05.
 */
public class CityTest {
    private CityRepository repo;
    private String id;


        @BeforeMethod
        public void setUp() throws Exception {
            repo = new CityRepositoryImpl();
        }

        @Test
        public void create() throws Exception {
            City city1 = CityFactory.getCity("Cape Town");
            City city2 = CityFactory.getCity("Bellville");
            id = city1.getId();
            System.out.println(" City 1 " + city1.getId());
            System.out.println(" City 3 " + city2);
            repo.save(city1);
            Assert.assertNotNull(city1.getId());
        }

        @Test(dependsOnMethods = "create")
        public void read() throws Exception {
            City city = repo.findById(id);
            Assert.assertNotNull(city);
        }

        @Test(dependsOnMethods = "read")
        public void update() throws Exception {
            City city = repo.findById(id);
            City newCity = new City.Builder().copy(city).city("1").build();
            repo.update(newCity);
            City updatedCity = repo.findById(id);
            Assert.assertEquals("1", updatedCity.getCity());
        }

        @Test(dependsOnMethods = "update")
        public void delete() throws Exception {
            City city = repo.findById(id);
            repo.delete(city);
            City deletedCity = repo.findById(id);
            Assert.assertNull(deletedCity);
        }
}