/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.PersonLanguage;
import hashwork.repository.people.Impl.PersonLanguageRepositoryImpl;
import hashwork.repository.people.PersonLanguageRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author BKLAAS1
 */
public class PersonLanguageTest {
    
    private PersonLanguageRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonLanguageRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        PersonLanguage language1 = PersonLanguageFactory.getPersonLanguage("Test1", "Test2","Test3","Test4","Test5");
        PersonLanguage language2 = PersonLanguageFactory.getPersonLanguage ("Test1", "Test2","Test3","Test4","Test5");
        PersonLanguage language3 = PersonLanguageFactory.getPersonLanguage ("Test1", "Test2","Test3","Test4","Test5");
        
        System.out.println(" Language 1 " + language1.getId());
        System.out.println(" Language 2 " + language2.getId());
        System.out.println(" Language 3 " + language3);
        repo.save(language1);
        Assert.assertNotNull(language1.getLanguageId(),"Xhosa");
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PersonLanguage personLanguage = repo.findById(id);
        Assert.assertNotNull(personLanguage);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PersonLanguage personLanguage = repo.findById(id);
        PersonLanguage newPersonLanguage = new PersonLanguage.Builder().copy(personLanguage).languageId("Xhosa").build();
        repo.update(newPersonLanguage);
        PersonLanguage updatedPersonLanguage = repo.findById(id);
        Assert.assertEquals("Xhosa", updatedPersonLanguage.getLanguageId());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PersonLanguage personLanguage = repo.findById(id);
        repo.delete(personLanguage);
        PersonLanguage deletedLanguage = repo.findById(id);
        Assert.assertNull(deletedLanguage);
    }
}
