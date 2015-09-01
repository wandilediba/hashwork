package hashwork.repository.ui.contactdetails.Impl;

import hashwork.domain.ui.contactdetails.EmailAddress;
import hashwork.repository.ui.contactdetails.EmailAddressRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/01.
 */
public class EmailAddressRepositoryImpl implements EmailAddressRepository {
    Map<String, EmailAddress> lists = new HashMap<>();

    @Override
    public EmailAddress findById(String s) {
        return lists.get(s);
    }

    @Override
    public EmailAddress save(EmailAddress entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public EmailAddress update(EmailAddress entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(EmailAddress entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<EmailAddress> findAll() {
        Set<EmailAddress> set = new HashSet<>();
        for (Map.Entry<String, EmailAddress> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}