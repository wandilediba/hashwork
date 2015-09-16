package hashwork.services.ui.position.Impl;

import hashwork.domain.ui.position.DepartureReason;
import hashwork.repository.ui.positions.Impl.DepartureReasonRepsitoryImpl;
import hashwork.services.ui.position.DepartureReasonService;

import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class DepartureReasonServiceImpl implements DepartureReasonService {


    @Override
    public DepartureReason findById(String id) {
        return new DepartureReasonRepsitoryImpl().findById(id);
    }

    @Override
    public DepartureReason save(DepartureReason entity) {
        return new DepartureReasonRepsitoryImpl().save(entity);
    }

    @Override
    public DepartureReason update(DepartureReason entity) {
        return new DepartureReasonRepsitoryImpl().update(entity);
    }

    @Override
    public void delete(DepartureReason entity) {
        new DepartureReasonRepsitoryImpl().delete(entity);

    }

    @Override
    public Set<DepartureReason> findAll() {
        return new DepartureReasonRepsitoryImpl().findAll();
    }

}
