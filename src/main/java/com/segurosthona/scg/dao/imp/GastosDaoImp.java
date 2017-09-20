package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.GastosDao;
import com.segurosthona.scg.dao.RolDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.Gastos;
import com.segurosthona.scg.modelo.entidad.Rol;




/**
 * Implementación del acceso a datos del repositorio de Roles
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class GastosDaoImp  extends AbstractHibernateDao<Gastos> implements GastosDao{

	public GastosDaoImp() {
        super();
        setClazz(Gastos.class);
    }
}
