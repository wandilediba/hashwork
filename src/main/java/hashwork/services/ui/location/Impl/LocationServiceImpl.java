package hashwork.services.ui.location.Impl;

import hashwork.domain.ui.location.Location;
import hashwork.repository.ui.location.Impl.LocationRepositoryImpl;
import hashwork.services.ui.location.LocationService;

import java.util.Set;

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

}
