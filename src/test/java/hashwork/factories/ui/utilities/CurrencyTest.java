/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.ui.utilities;

import hashwork.domain.ui.util.Currency;
import hashwork.factories.ui.util.CurrencyFactory;
import hashwork.repository.ui.utililties.CurrencyRepository;
import hashwork.repository.ui.utililties.Impl.CurrencyRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author bulelani
 */
public class CurrencyTest {
    private CurrencyRepository repo;
    private String id;

    @BeforeMethod
    public void setUp() throws Exception {
        repo = new CurrencyRepositoryImpl();
    }
    @Test
    public void create() throws Exception {
        Currency currency1 = CurrencyFactory.getCurrency("US Dollar", "$", "100");
        Currency currency2 = CurrencyFactory.getCurrency("Rand", "R", "1001");
        Currency currency3 = CurrencyFactory.getCurrency("Pound", "@", "1002");
        id = currency1.getId();
        System.out.println(" Currency 1 " + currency1.getId());
        System.out.println(" Currency 2" + currency2.getId());
        System.out.println(" Currency 3 " + currency3);
        repo.save(currency1);
        Assert.assertNotNull(currency1.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Currency currency1 = repo.findById(id);
        Assert.assertNotNull(currency1);
    }
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Currency currency = repo.findById(id);
        Currency newCurrency = new Currency.Builder().copy(currency).name("TEST").build();
        repo.update(newCurrency);
        Currency updatedCurrency = repo.findById(id);
        Assert.assertEquals("TEST", updatedCurrency.getName());
    }
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Currency currency = repo.findById(id);
        repo.delete(currency);
        Currency deletedCurrency = repo.findById(id);
        Assert.assertNull(deletedCurrency);
    }
}
