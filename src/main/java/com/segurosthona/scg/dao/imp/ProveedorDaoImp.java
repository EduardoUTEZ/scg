package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;


import com.segurosthona.scg.dao.ProveedorDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.Proveedor;




/**
 * Implementación del acceso a datos del repositorio de Roles
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class ProveedorDaoImp  extends AbstractHibernateDao<Proveedor> implements ProveedorDao{

	public ProveedorDaoImp() {
        super();
        setClazz(Proveedor.class);
    }
}
