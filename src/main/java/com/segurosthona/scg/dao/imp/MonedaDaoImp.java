package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.MonedaDao;
import com.segurosthona.scg.dao.RolDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.Moneda;
import com.segurosthona.scg.modelo.entidad.Rol;




/**
 * Implementación del acceso a datos del repositorio de Roles
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class MonedaDaoImp  extends AbstractHibernateDao<Moneda> implements MonedaDao{

	public MonedaDaoImp() {
        super();
        setClazz(Moneda.class);
    }
}
