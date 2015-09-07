package hashwork.services.ui.location.Impl;

import hashwork.domain.ui.location.ContactList;
import hashwork.repository.ui.location.Impl.ContactListRepositoryImpl;
import hashwork.services.ui.location.ContactListService;

import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class ContactListServiceImpl implements ContactListService {

    @Override
    public ContactList findById(String id) {
        return new ContactListRepositoryImpl().findById(id);
    }

    @Override
    public ContactList save(ContactList entity) {
        return new ContactListRepositoryImpl().save(entity);
    }

    @Override
    public ContactList update(ContactList entity) {
        return new ContactListRepositoryImpl().update(entity);
    }

    @Override
    public void delete(ContactList entity) {
        new ContactListRepositoryImpl().delete(entity);

    }

    @Override
    public Set<ContactList> findAll() {
        return new ContactListRepositoryImpl().findAll();
    }

}
