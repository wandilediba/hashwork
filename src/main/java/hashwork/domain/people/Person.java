package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Person implements Serializable, Comparable<Person>{
    private static final long serialVersionUID = 1L;
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    private String title;
    private String authvalue;
    @Override
    public int compareTo(Person o) {
        return lastName.compareTo(o.lastName);}
}
