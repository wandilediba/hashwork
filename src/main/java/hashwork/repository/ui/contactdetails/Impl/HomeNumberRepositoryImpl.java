package hashwork.repository.ui.contactdetails.Impl;

import hashwork.domain.ui.contactdetails.HomeNumber;
import hashwork.repository.ui.contactdetails.HomeNumberRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/01.
 */
public class HomeNumberRepositoryImpl implements HomeNumberRepository {
    Map<String, HomeNumber> lists = new HashMap<>();

    @Override
    public HomeNumber findById(String s) {
        return lists.get(s);
    }

    @Override
    public HomeNumber save(HomeNumber entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public HomeNumber update(HomeNumber entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(HomeNumber entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<HomeNumber> findAll() {
        Set<HomeNumber> set = new HashSet<>();
        for (Map.Entry<String, HomeNumber> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}