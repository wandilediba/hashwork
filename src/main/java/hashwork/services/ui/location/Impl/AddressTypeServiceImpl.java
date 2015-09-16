package hashwork.services.ui.location.Impl;

import hashwork.domain.ui.location.AddressType;
import hashwork.repository.ui.location.Impl.AddressTypeRepositoryImpl;
import hashwork.services.ui.location.AddressTypeService;

import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class AddressTypeServiceImpl implements AddressTypeService {


    @Override
    public AddressType findById(String id) {
        return new AddressTypeRepositoryImpl().findById(id);
    }

    @Override
    public AddressType save(AddressType entity) {
        return new AddressTypeRepositoryImpl().save(entity);
    }

    @Override
    public AddressType update(AddressType entity) {
        return new AddressTypeRepositoryImpl().update(entity);
    }

    @Override
    public void delete(AddressType entity) {
        new AddressTypeRepositoryImpl().delete(entity);

    }

    @Override
    public Set<AddressType> findAll() {
        return new AddressTypeRepositoryImpl().findAll();
    }

}
