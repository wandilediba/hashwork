package hashwork.repository.ui.country.Impl;

import hashwork.domain.ui.country.Country;
import hashwork.repository.ui.country.CountryRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/01.
 */
public class CountryRepositoryImpl implements CountryRepository {
    Map<String, Country> lists = new HashMap<>();

    @Override
    public Country findById(String s) {
        return lists.get(s);
    }

    @Override
    public Country save(Country entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Country update(Country entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Country entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Country> findAll() {
        Set<Country> set = new HashSet<>();
        for (Map.Entry<String, Country> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}