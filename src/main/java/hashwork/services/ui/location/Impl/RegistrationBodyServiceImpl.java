package hashwork.services.ui.location.Impl;

import hashwork.domain.ui.location.RegistrationBody;
import hashwork.repository.ui.location.Impl.RegistrationBodyRepositoryImpl;
import hashwork.services.ui.location.RegistrationBodyService;

import java.util.Set;

/**
 * Created by garran on 2015/09/06.
 */
public class RegistrationBodyServiceImpl implements RegistrationBodyService {

    @Override
    public RegistrationBody findById(String id) {
        return new RegistrationBodyRepositoryImpl().findById(id);
    }

    @Override
    public RegistrationBody save(RegistrationBody entity) {
        return new RegistrationBodyRepositoryImpl().save(entity);
    }

    @Override
    public RegistrationBody update(RegistrationBody entity) {
        return new RegistrationBodyRepositoryImpl().update(entity);
    }

    @Override
    public void delete(RegistrationBody entity) {
        new RegistrationBodyRepositoryImpl().delete(entity);

    }

    @Override
    public Set<RegistrationBody> findAll() {
        return new RegistrationBodyRepositoryImpl().findAll();
    }

}
