/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.office.Impl;

import hashwork.domain.office.Office;
import hashwork.repository.office.Impl.OfficeRepositoryImpl;
import hashwork.repository.office.OfficeRepository;
import hashwork.services.office.OfficeService;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository repo = new OfficeRepositoryImpl();
    @Override
    public Office findById(String id) {
     return repo.findById(id);
    }

    @Override
    public Office save(Office entity) {
        return repo.save(entity);
    }

    @Override
    public Office update(Office entity) {
     return repo.save(entity);
    }

    @Override
    public void delete(Office entity) {
       repo.delete(entity);
    }

    @Override
    public Set<Office> findAll() {
       return repo.findAll();
    }
    
}
