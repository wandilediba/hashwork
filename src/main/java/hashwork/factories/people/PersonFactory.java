package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.Person;

/**
 * Created by hashcode on 2015/08/16.
 */
public class PersonFactory {
    
    public static Person getPerson ( String firstName,
                                    String middleName,
                                    String emailAddress,
                                    String lastName,
                                    String title,
                                    String authvalue)
    {
        Person person = new Person.Builder()
                .id(KeyGenerator.getEntityId())
                .firstName(firstName)
                .middletName(middleName)
                .lastName(lastName)
                .title(title)
                .authvalue(authvalue)
                .emailAddress(emailAddress)
                .build();
                
      return person;
    }
}

     