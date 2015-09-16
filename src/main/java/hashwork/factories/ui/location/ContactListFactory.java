package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.ContactList;

/**
 * Created by garran on 2015/09/06.
 */
public class ContactListFactory {
    public static ContactList getContactList(String name) {
        ContactList contactList = new ContactList.Builder()
                .id(KeyGenerator.getEntityId())
                .name(name).build();
        return contactList;
    }
}
