package hashwork.app.facade;

import hashwork.services.ui.position.*;
import hashwork.services.ui.position.Impl.*;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionFacade {

    public final static DepartureReasonService departureReasonService = new DepartureReasonServiceImpl();
    public final static PositionLifeCycleService positionLifeCycleService = new PositionLifeCycleServiceImpl();
    public final static PositionSalarySourceService positionSalarySourceService = new PositionSalarySourceServiceImpl();
    public final static PositionService positionService = new PositionServiceImpl();
    public final static PositionTypeService positionTypeService = new PositionTypeServiceImpl();
}
