/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.education;

import hashwork.repository.ui.education.*;
import hashwork.domain.ui.education.Degree;
import hashwork.factories.ui.education.DegreeFactory;
import hashwork.repository.ui.education.Impl.DegreeRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author VUYO
 */
public class DegreeTest {
    
    private DegreeRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new DegreeRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Degree degree1 = DegreeFactory.getDegree("Bachelor", "it", "Information Technology");
        Degree degree2 = DegreeFactory.getDegree("Diploma", "ed", "Education");
        Degree degree3 = DegreeFactory.getDegree("Masters", "eng", "Engineering");
        Degree degree4 = DegreeFactory.getDegree("Phd", "he", "Heath");
        id = degree1.getId();
        System.out.println(" Degree 1 " + degree1.getId());
        System.out.println(" Degree 2 " + degree2.getId());
        System.out.println(" Degree 3 " + degree3);
        repo.save(degree1);
        Assert.assertNotNull(degree1.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Degree degree = repo.findById(id);
        Assert.assertNotNull(degree);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Degree degree = repo.findById(id);
        Degree newDegree = new Degree.Builder().copy(degree).degreeName("TEST").build();
        repo.update(newDegree);
        Degree updatedDegree = repo.findById(id);
        Assert.assertEquals("TEST", updatedDegree.getDegreeName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Degree degree = repo.findById(id);
        repo.delete(degree);
        Degree deletedDegree = repo.findById(id);
        Assert.assertNull(deletedDegree);
    }
    
}
