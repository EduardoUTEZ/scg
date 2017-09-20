package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.DetalleReasignacionDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.DetalleReasignacion;




/**
 * Implementación del acceso a datos del repositorio de DetalleReasignacion
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class DetalleReasignacionImp  extends AbstractHibernateDao<DetalleReasignacion> implements DetalleReasignacionDao{

	public DetalleReasignacionImp() {
        super();
        setClazz(DetalleReasignacion.class);
    }

}
