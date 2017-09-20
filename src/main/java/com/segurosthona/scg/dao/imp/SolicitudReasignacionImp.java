package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.SolicitudReasignacionDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacion;




/**
 * Implementación del acceso a datos del repositorio de SolicitudReasignacion
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class SolicitudReasignacionImp  extends AbstractHibernateDao<SolicitudReasignacion> implements SolicitudReasignacionDao{

	public SolicitudReasignacionImp() {
        super();
        setClazz(SolicitudReasignacion.class);
    }

}
