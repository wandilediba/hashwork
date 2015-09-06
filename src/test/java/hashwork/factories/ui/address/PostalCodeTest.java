package hashwork.factories.ui.address;

import hashwork.domain.ui.address.PostalCode;
import hashwork.repository.ui.address.Impl.PostalCodeRepositoryImpl;
import hashwork.repository.ui.address.PostalCodeRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by garran on 2015/08/30.
 */
public class PostalCodeTest {
    private PostalCodeRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PostalCodeRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        PostalCode postalCode1 = PostalCodeFactory.getPostalCode("7945");
        PostalCode postalCode2 = PostalCodeFactory.getPostalCode("4561");
        PostalCode postalCode3 = PostalCodeFactory.getPostalCode("4566");
        id = postalCode1.getId();
        System.out.println(" Postal Code 1 " + postalCode1.getId());
        System.out.println(" Postal Code 2 " + postalCode2.getId());
        System.out.println(" Postal Code 3 " + postalCode3);
        repo.save(postalCode1);
        Assert.assertNotNull(postalCode1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PostalCode postalCode = repo.findById(id);
        Assert.assertNotNull(postalCode);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PostalCode postalCode = repo.findById(id);
        PostalCode newPostalCode = new PostalCode.Builder().copy(postalCode).postalCode("1").build();
        repo.update(newPostalCode);
        PostalCode updatedPostalCode = repo.findById(id);
        Assert.assertEquals("1", updatedPostalCode.getPostalCode());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PostalCode postalCode = repo.findById(id);
        repo.delete(postalCode);
        PostalCode deletedPostalCode = repo.findById(id);
        Assert.assertNull(deletedPostalCode);
    }
}
