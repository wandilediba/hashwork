package hashwork.services;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/21.
 */
public interface Services<S, ID> {

    public S findById(ID id);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public Set<S> findAll();
}