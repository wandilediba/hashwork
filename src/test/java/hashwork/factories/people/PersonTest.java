/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.domain.people.Person;
import hashwork.repository.people.Impl.PersonRepositoryImpl;
import hashwork.repository.people.PersonRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author BKLAAS1
 */
public class PersonTest {
    
    private PersonRepository repo;
    private String id;


    @BeforeMethod
    public void setUp() throws Exception {
        repo = new PersonRepositoryImpl();
    }

    @Test
    public void create() throws Exception {
        Person person1 = PersonFactory.getPerson("Bongani", "Shuan","Worker@gmail.com","Klaas","Mr","Tech");
        Person person2 = PersonFactory.getPerson("Sonia", "Maggy","Parow@gmail.com","Nene","Ms","Tech");
        Person person3 = PersonFactory.getPerson("Lillian", "anele","city@gmail.com","Dube","Mrs","Tech");
        
        System.out.println(" Person 1 " + person1.getId());
        System.out.println(" Person 2 " + person2.getId());
        System.out.println(" Person 3 " + person3);
        repo.save(person1);
        Assert.assertNotNull(person1.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Person person = repo.findById(id);
        Assert.assertNotNull(person);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Person person = repo.findById(id);
        Person newPerson = new Person.Builder().copy(person).firstName("Bongani").build();
        repo.update(newPerson);
        Person updatedPerson = repo.findById(id);
        Assert.assertEquals("Bongani", updatedPerson.getFirstName());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Person person = repo.findById(id);
        repo.delete(person);
        Person deletedPerson = repo.findById(id);
        Assert.assertNull(deletedPerson);
    }
}
