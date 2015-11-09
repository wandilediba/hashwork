/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.ui.education;

import hashwork.domain.ui.education.EducationType;
import hashwork.factories.ui.education.EducationTypeFactory;
import hashwork.repository.ui.education.Impl.EducationTypeRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author VUYO
 */
public class EducationTypeTest {
    
    private EducationTypeRepository repo;
    private String id;
    
    @BeforeMethod
    public void setUp() throws Exception {
        repo = new EducationTypeRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        EducationType educationtype1 = EducationTypeFactory.getEducation("WORKER");
        EducationType educationtype2 = EducationTypeFactory.getEducation("APPLICANT");
        EducationType educationtype3 = EducationTypeFactory.getEducation("PANELIST");
        id = educationtype1.getId();
        System.out.println(" Role 1 " + educationtype1.getId());
        System.out.println(" Role 2 " + educationtype2.getId());
        System.out.println(" Role 3 " + educationtype3);
        repo.save(educationtype1);
        Assert.assertNotNull(educationtype1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        EducationType educationtype = repo.findById(id);
        Assert.assertNotNull(educationtype);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        EducationType educationtype = repo.findById(id);
        EducationType newEducationType = new EducationType.Builder().copy(educationtype).name("TEST").build();
        repo.update(newEducationType);
        EducationType updatedEducationType = repo.findById(id);
        Assert.assertEquals("TEST", updatedEducationType.getName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        EducationType education = repo.findById(id);
        repo.delete(education);
        EducationType deletedEducationtype = repo.findById(id);
        Assert.assertNull(deletedEducationtype);

    }
    
}
