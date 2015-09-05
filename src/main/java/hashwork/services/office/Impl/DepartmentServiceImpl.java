/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.office.Impl;

import hashwork.domain.office.Department;
import hashwork.repository.office.DepartmentRepository;
import hashwork.repository.office.Impl.DepartmentRepositoryImpl;
import hashwork.services.office.DepartmentService;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class DepartmentServiceImpl implements DepartmentService{

  private final DepartmentRepository repo = new DepartmentRepositoryImpl();
    @Override
    public Department findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Department save(Department entity) {
      return repo.save(entity);
    }

    @Override
    public Department update(Department entity) {
     return repo.save(entity);
    }

    @Override
    public void delete(Department entity) {
        repo.delete(entity);
    }

    @Override
    public Set<Department> findAll() {
        return repo.findAll();
    }
    
}
