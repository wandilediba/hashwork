/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashwork.repository.mongo;

import java.io.Serializable;
import zm.hashcode.hashwork.repository.dao.DAO;

/**
 *
 * @author boniface
 */
public interface GenericDAO < T extends Serializable > extends DAO< T, String>{
	void setClazz( final Class< T > clazzToSet );

}

