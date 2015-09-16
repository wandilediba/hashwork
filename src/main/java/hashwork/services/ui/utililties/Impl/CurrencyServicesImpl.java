package hashwork.services.ui.utililties.Impl;

import hashwork.domain.ui.util.Currency;
import hashwork.repository.ui.utililties.Impl.CurrencyRepositoryImpl;
import hashwork.services.ui.utililties.CurrencyServices;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public class CurrencyServicesImpl implements CurrencyServices {

    @Override
    public Currency findById(String id) {
        return new CurrencyRepositoryImpl().findById(id);
    }

    @Override
    public Currency save(Currency entity) {
        return new CurrencyRepositoryImpl().save(entity);
    }

    @Override
    public Currency update(Currency entity) {
        return new CurrencyRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Currency entity) {
        new CurrencyRepositoryImpl().delete(entity);

    }

    @Override
    public Set<Currency> findAll() {
        return new CurrencyRepositoryImpl().findAll();
    }
}
