package hashwork.services.ui.region.Impl;

import hashwork.domain.ui.region.Province;
import hashwork.repository.ui.region.Impl.ProvinceRepositoryImpl;
import hashwork.services.ui.region.ProvinceService;

import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class ProvinceServiceImpl implements ProvinceService {

    @Override
    public Province findById(String id) {
        return new ProvinceRepositoryImpl().findById(id);
    }

    @Override
    public Province save(Province entity) {
        return new ProvinceRepositoryImpl().save(entity);
    }

    @Override
    public Province update(Province entity) {
        return new ProvinceRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Province entity) {
        new ProvinceRepositoryImpl().delete(entity);

    }

    @Override
    public Set<Province> findAll() {
        return new ProvinceRepositoryImpl().findAll();
    }
}
