package hashwork.repository.ui.utililties.Impl;

import hashwork.app.conf.Connection;
import hashwork.repository.ui.utililties.CurrencyRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import hashwork.domain.ui.util.Currency;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class CurrencyRepositoryImpl implements CurrencyRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Currency> lists = redisson.getMap("currency");

    @Override
    public Currency findById(String s) {
        return lists.get(s);
    }

    @Override
    public Currency save(Currency entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Currency update(Currency entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Currency entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Currency> findAll() {
        Set<Currency> set = new HashSet<>();
        for (Map.Entry<String, Currency> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
