package hashwork.repository.ui.City.Impl;

import hashwork.domain.ui.City.City;
import hashwork.repository.ui.City.CityRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/05.
 */
public class CityRepositoryImpl implements CityRepository {
        Map<String, City> lists = new HashMap<>();

        @Override
        public City findById(String s) {
            return lists.get(s);
        }

        @Override
        public City save(City entity) {
            return lists.put(entity.getId(), entity);
        }

        @Override
        public City update(City entity) {
            return lists.put(entity.getId(), entity);
        }

        @Override
        public void delete(City entity) {
            lists.remove(entity.getId());
        }

        @Override
        public Set<City> findAll() {
            Set<City> set = new HashSet<>();
            for (Map.Entry<String, City> entry : lists.entrySet()) {
                set.add(entry.getValue());
            }
            return set;
        }
    }