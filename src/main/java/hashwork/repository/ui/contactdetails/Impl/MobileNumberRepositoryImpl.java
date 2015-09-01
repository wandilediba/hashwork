package hashwork.repository.ui.contactdetails.Impl;

import hashwork.domain.ui.contactdetails.MobileNumber;
import hashwork.repository.ui.contactdetails.MobileNumberRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/01.
 */
public class MobileNumberRepositoryImpl implements MobileNumberRepository {
    Map<String, MobileNumber> lists = new HashMap<>();

    @Override
    public MobileNumber findById(String s) {
        return lists.get(s);
    }

    @Override
    public MobileNumber save(MobileNumber entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public MobileNumber update(MobileNumber entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(MobileNumber entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<MobileNumber> findAll() {
        Set<MobileNumber> set = new HashSet<>();
        for (Map.Entry<String, MobileNumber> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}