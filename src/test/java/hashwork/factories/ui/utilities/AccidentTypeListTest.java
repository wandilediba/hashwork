/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.utilities;

import hashwork.domain.ui.util.AccidentTypeList;
import hashwork.factories.ui.util.AccidentTypeListFactory;
import hashwork.repository.ui.utililties.AccidentTypeListRepository;
import hashwork.repository.ui.utililties.Impl.AccidentTypeListRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author bulelani
 */
public class AccidentTypeListTest {
    private AccidentTypeListRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new AccidentTypeListRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        AccidentTypeList accidentTypeList1 = AccidentTypeListFactory.getAccidentTpyeList("Burn","burned injuries");
        AccidentTypeList accidentTypeList2 = AccidentTypeListFactory.getAccidentTpyeList("Back neck", "sore neck");
        AccidentTypeList accidentTypeList3 = AccidentTypeListFactory.getAccidentTpyeList("Muscle pains", "Sore muscles");
        id = accidentTypeList1.getId();
        System.out.println(" AccidentTypeList 1 " + accidentTypeList1.getId());
        System.out.println(" AccidentTypeList 2" + accidentTypeList2.getId());
        System.out.println(" AccidentTypeList 3 " + accidentTypeList3);
        repo.save(accidentTypeList1);
        Assert.assertNotNull(accidentTypeList1.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        AccidentTypeList accidentTypeList1 = repo.findById(id);
        Assert.assertNotNull(accidentTypeList1);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        AccidentTypeList accidentTypeList = repo.findById(id);
        AccidentTypeList newAccidentTypeList = new AccidentTypeList.Builder().copy(accidentTypeList).name("TEST").build();
        repo.update(newAccidentTypeList);
        AccidentTypeList updatedAccidentTypeList = repo.findById(id);
        Assert.assertEquals("TEST", updatedAccidentTypeList.getName());
    }
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        AccidentTypeList accidentTypeList = repo.findById(id);
        repo.delete(accidentTypeList);
        AccidentTypeList deletedAccidentTypeList = repo.findById(id);
        Assert.assertNull(deletedAccidentTypeList);
    }
}

