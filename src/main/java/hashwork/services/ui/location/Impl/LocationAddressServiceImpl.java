package hashwork.services.ui.location.Impl;

import hashwork.domain.office.LocationAddress;
import hashwork.repository.ui.location.Impl.LocationAddressRepositoryImpl;
import hashwork.services.ui.location.LocationAddressService;

import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class LocationAddressServiceImpl implements LocationAddressService {

    @Override
    public LocationAddress findById(String id) {
        return new LocationAddressRepositoryImpl().findById(id);
    }

    @Override
    public LocationAddress save(LocationAddress entity) {
        return new LocationAddressRepositoryImpl().save(entity);
    }

    @Override
    public LocationAddress update(LocationAddress entity) {
        return new LocationAddressRepositoryImpl().update(entity);
    }

    @Override
    public void delete(LocationAddress entity) {
        new LocationAddressRepositoryImpl().delete(entity);

    }

    @Override
    public Set<LocationAddress> findAll() {
        return new LocationAddressRepositoryImpl().findAll();
    }

}
