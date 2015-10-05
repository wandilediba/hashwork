package hashwork.repository.ui.locations;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.location.Location;
import hashwork.repository.ui.location.Impl.LocationRepositoryImpl;
import hashwork.repository.ui.location.LocationRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.function.Predicate;


/**
 * Created by hashcode on 2015/09/08.
 */
public class LocationsTest {
    private LocationRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

        repository = new LocationRepositoryImpl();

    }

    @Test
    public void readAll() throws Exception {


        Redisson redisson = Connection.getConnection();
        RMap<String, Location> map = redisson.getMap("location");

        Set<Location> locations = repository.findAll();

        final Predicate<Location> notNull = loca -> loca.getParentId() != null;

        final Predicate<Location> startsWithN = location -> location.getParentId().equalsIgnoreCase("f5c3f4bf-e77e-4024-be5e-1af9c39dc0ef");

        long count = locations.stream().parallel().filter(notNull).filter(startsWithN).count();

        System.out.println("The Count is " + count);
        Assert.assertTrue(count > 0);


    }
}
