package hashwork.factories.ui.demographics;

import hashwork.domain.ui.demographics.Language;
import hashwork.repository.ui.demographics.Impl.LanguageRepositoryImpl;
import hashwork.repository.ui.demographics.LanguageRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by hashcode on 2015/08/24.
 */
public class LanguageTest {
    private LanguageRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new LanguageRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Language lang = LanguageFactory.getLanguage("French");

        id = lang.getId();
        System.out.println(" Language " + lang.getId());
        repo.save(lang);
        Assert.assertNotNull(lang.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Language lang = repo.findById(id);
        Assert.assertNotNull(lang);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Language lang = repo.findById(id);
        Language newLanguageList = new Language.Builder().copy(lang).name("TEST").build();
        repo.update(newLanguageList);
        Language updatedLanguageList = repo.findById(id);
        Assert.assertEquals("TEST", updatedLanguageList.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Language lang = repo.findById(id);
        repo.delete(lang);
        Language deletedLanguage = repo.findById(id);
        Assert.assertNull(deletedLanguage);
    }
}
