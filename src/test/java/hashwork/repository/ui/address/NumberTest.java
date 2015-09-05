package hashwork.repository.ui.address;

import hashwork.domain.ui.address.Number;
import hashwork.factories.ui.address.NumberFactory;
import hashwork.repository.ui.address.Impl.NumberRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by garran on 2015/08/30.
 */
public class NumberTest {
    private NumberRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new NumberRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Number number1 = NumberFactory.getNumber("1");
        Number number2 = NumberFactory.getNumber("2");
        Number number3 = NumberFactory.getNumber("3");
        id = number1.getId();
        System.out.println(" Role 1 " + number1.getId());
        System.out.println(" Role 2 " + number2.getId());
        System.out.println(" Role 3 " + number3);
        repo.save(number1);
        Assert.assertNotNull(number1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Number number = repo.findById(id);
        Assert.assertNotNull(number);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Number number = repo.findById(id);
        Number newNumber = new Number.Builder().copy(number).number("TEST").build();
        repo.update(newNumber);
        Number updatedNumber = repo.findById(id);
        Assert.assertEquals("TEST", updatedNumber.getNumber());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Number number = repo.findById(id);
        repo.delete(number);
        Number deletedNumber = repo.findById(id);
        Assert.assertNull(deletedNumber);
    }
}
