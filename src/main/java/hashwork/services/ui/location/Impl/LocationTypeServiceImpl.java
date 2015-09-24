package hashwork.services.ui.location.Impl;

import hashwork.domain.ui.location.LocationType;
import hashwork.repository.ui.location.Impl.LocationTypeRepositoryImpl;
import hashwork.services.ui.location.LocationTypeService;

import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationTypeServiceImpl implements LocationTypeService {

    @Override
    public LocationType findById(String id) {
        return new LocationTypeRepositoryImpl().findById(id);
    }

    @Override
    public LocationType save(LocationType entity) {
        return new LocationTypeRepositoryImpl().save(entity);
    }

    @Override
    public LocationType update(LocationType entity) {
        return new LocationTypeRepositoryImpl().update(entity);
    }

    @Override
    public void delete(LocationType entity) {
        new LocationTypeRepositoryImpl().delete(entity);

    }

    @Override
    public Set<LocationType> findAll() {
        return new LocationTypeRepositoryImpl().findAll();
    }

}
