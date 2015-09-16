package hashwork.app.facade;

import hashwork.services.ui.region.Impl.ProvinceServiceImpl;
import hashwork.services.ui.region.ProvinceService;

/**
 * Created by garran on 2015/09/13.
 */
public class RegionFacade {

    public final static ProvinceService provinceServices = new ProvinceServiceImpl();

}
