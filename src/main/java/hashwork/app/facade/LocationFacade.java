package hashwork.app.facade;

import hashwork.services.ui.location.*;
import hashwork.services.ui.location.Impl.*;

/**
 * Created by hashcode on 2015/09/07.
 */
public class LocationFacade {

    public final static ContactListService contactListService = new ContactListServiceImpl();
    public final static RegistrationBodyService registrationBodyService = new RegistrationBodyServiceImpl();
    public final static LocationTypeService locationTypeService = new LocationTypeServiceImpl();
    public final static LocationService locationService = new LocationServiceImpl();
    public final static AddressTypeService addressTypeService = new AddressTypeServiceImpl();
    public final static LocationAddressService locationAddressService = new LocationAddressServiceImpl();
}
