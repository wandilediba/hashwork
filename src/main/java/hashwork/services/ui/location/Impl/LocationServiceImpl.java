package hashwork.services.ui.location.Impl;

import hashwork.domain.ui.location.Location;
import hashwork.repository.ui.location.Impl.LocationRepositoryImpl;
import hashwork.services.ui.location.LocationService;

import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationServiceImpl implements LocationService {

    @Override
    public Location findById(String id) {
        return new LocationRepositoryImpl().findById(id);
    }

    @Override
    public Location save(Location entity) {
        return new LocationRepositoryImpl().save(entity);
    }

    @Override
    public Location update(Location entity) {
        return new LocationRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Location entity) {
        new LocationRepositoryImpl().delete(entity);

    }

    @Override
    public Set<Location> findAll() {
        return new LocationRepositoryImpl().findAll();
    }

    @Override
    public boolean hasChildren(String id) {
        final Predicate<Location> notNull = location -> location.getParentId() != null;
        final Predicate<Location> filtered = location -> location.getParentId().equalsIgnoreCase(id);
        return findAll().parallelStream().filter(notNull).filter(filtered).count() > 0;
    }

    @Override
    public long numberofChildred(String id) {
        final Predicate<Location> notNull = location -> location.getParentId() != null;
        final Predicate<Location> filtered = location -> location.getParentId().equalsIgnoreCase(id);
        return findAll().parallelStream().filter(notNull).filter(filtered).count();
    }
}
