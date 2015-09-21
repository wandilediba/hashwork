package hashwork.app.facade;

import hashwork.services.ui.utililties.*;
import hashwork.services.ui.utililties.Impl.*;

/**
 * Created by garran on 2015/09/13.
 */
public class UtilFacade {

    public final static AccidentTypeListService accidentTypeListService = new AccidentTypeListServiceImpl();
    public final static CurrencyServices currencyServices = new CurrencyServicesImpl();
    public final static DisciplineActionTypeListService disciplineActionTypeListService = new DisciplineActionTypeListServiceImpl();
    public final static FunderService funderService = new FunderServiceImpl();
    public final static StatusService statusService = new StatusServiceImpl();
}
