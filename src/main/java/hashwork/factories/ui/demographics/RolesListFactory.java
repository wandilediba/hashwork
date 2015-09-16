package hashwork.factories.ui.demographics;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.demographics.RolesList;

/**
 * Created by zamzam on 15/08/22.
 */
public class RolesListFactory {
    public static RolesList getRolesList(String roleName, String description) {
        RolesList rolesList = new RolesList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .roleName(roleName)
                .description(description)
                .build();
        return rolesList;
    }
}
