/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.address.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Garran
 */
public class NumberModel implements Serializable {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
