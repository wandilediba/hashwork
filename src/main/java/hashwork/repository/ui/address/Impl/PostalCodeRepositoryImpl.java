package hashwork.repository.ui.address.Impl;
import hashwork.domain.ui.address.PostalCode;
import hashwork.repository.ui.address.PostalCodeRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Created by garran on 2015/08/30.
 */
public class PostalCodeRepositoryImpl implements PostalCodeRepository {
    Map<String, Number> lists = new HashMap<>();

    @Override
    public PostalCode findById(String s) {
        return lists.get(s);
    }

    @Override
    public PostalCode save(PostalCode entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public PostalCode update(PostalCode entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(PostalCode entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<PostalCode> findAll() {
        Set<PostalCode> set = new HashSet<>();
        for (Map.Entry<String, PostalCode> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}