/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.utilities;

import hashwork.domain.ui.util.DisciplineActionTypeList;
import hashwork.factories.ui.util.DisciplineActionTypeListFactory;
import hashwork.repository.ui.utililties.DisciplineActionTypeListRepository;
import hashwork.repository.ui.utililties.Impl.DisciplineActionTypeListRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author bulelani
 */
public class DisciplineTypeListTest {
    private DisciplineActionTypeListRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new DisciplineActionTypeListRepositoryImpl();
    }
    @Test
    public void create() throws Exception {
        DisciplineActionTypeList disciplineActionTypeList1 = DisciplineActionTypeListFactory.getDisciplineActionTypeList("First discipline","Discipline");
        DisciplineActionTypeList disciplineActionTypeList2 = DisciplineActionTypeListFactory.getDisciplineActionTypeList("Second Discipline", "discipline two");
        DisciplineActionTypeList disciplineActionTypeList3 = DisciplineActionTypeListFactory.getDisciplineActionTypeList("Third discipline", "discipline three");
        id = disciplineActionTypeList1.getId();
        System.out.println(" Discipline Action TypeList 1 " + disciplineActionTypeList1.getId());
        System.out.println(" Discipline Action TypeList 2" + disciplineActionTypeList2.getId());
        System.out.println(" Discipline Action TypeList 3 " + disciplineActionTypeList3);
        repo.save(disciplineActionTypeList1);
        Assert.assertNotNull(disciplineActionTypeList1.getId());
    }
    @Test(dependsOnMethods = "create")
         public void read() throws Exception {
        DisciplineActionTypeList disciplineActionTypeList1 = repo.findById(id);
        Assert.assertNotNull(disciplineActionTypeList1);
    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        DisciplineActionTypeList disciplineActionTypeList = repo.findById(id);
        DisciplineActionTypeList newDisciplineActionTypeList = new DisciplineActionTypeList.Builder().copy(disciplineActionTypeList).name("TEST").build();
        repo.update(newDisciplineActionTypeList);
        DisciplineActionTypeList updatedDisciplineActionTypeList = repo.findById(id);
        Assert.assertEquals("TEST", updatedDisciplineActionTypeList.getName());
    }
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        DisciplineActionTypeList disciplineActionTypeList = repo.findById(id);
        repo.delete(disciplineActionTypeList);
        DisciplineActionTypeList deletedDisciplineActionTypeList = repo.findById(id);
        Assert.assertNull(deletedDisciplineActionTypeList);
    }
}
