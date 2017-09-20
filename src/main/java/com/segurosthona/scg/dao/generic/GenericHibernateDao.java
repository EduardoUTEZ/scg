/**
 * 
 */
package com.segurosthona.scg.dao.generic;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Clase gen�rica que extiende la clase abstracta de acceso a datos
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> Tipo de la clase a la que se asociar�n las operaciones DAO 
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao<T extends Serializable> extends AbstractHibernateDao<T> implements IGenericDao<T> {
    //
}