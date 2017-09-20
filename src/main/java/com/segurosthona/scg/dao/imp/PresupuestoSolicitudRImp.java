package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.PresupuestoSolicitudRDao;
import com.segurosthona.scg.dao.SolicitudReasignacionDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.PresupuestoSolicitudR;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacion;




/**
 * Implementación del acceso a datos del repositorio de SolicitudReasignacion
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class PresupuestoSolicitudRImp  extends AbstractHibernateDao<PresupuestoSolicitudR> implements PresupuestoSolicitudRDao{

	public PresupuestoSolicitudRImp() {
        super();
        setClazz(PresupuestoSolicitudR.class);
    }

}
