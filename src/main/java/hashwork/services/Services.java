package hashwork.services;

/**
 * Created by zamzam on 15/07/31.
 */

import java.util.Set;

public interface Services<S, ID> {

    public S findById(ID id);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public Set<S> findAll();
}
