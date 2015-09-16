package hashwork.repository.ui.location.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.location.ContactList;
import hashwork.repository.ui.location.ContactListRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class ContactListRepositoryImpl implements ContactListRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, ContactList> lists = redisson.getMap("contactList");

    @Override
    public ContactList findById(String s) {
        return lists.get(s);
    }

    @Override
    public ContactList save(ContactList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public ContactList update(ContactList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(ContactList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<ContactList> findAll() {
        Set<ContactList> set = new HashSet<>();
        for (Map.Entry<String, ContactList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}