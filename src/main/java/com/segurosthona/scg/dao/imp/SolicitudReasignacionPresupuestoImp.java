package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.SolicitudReasignacionDao;
import com.segurosthona.scg.dao.SolicitudReasignacionPresupuestoDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacion;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacionPresupuesto;




/**
 * Implementación del acceso a datos del repositorio de SolicitudReasignacion
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class SolicitudReasignacionPresupuestoImp  extends AbstractHibernateDao<SolicitudReasignacionPresupuesto> implements SolicitudReasignacionPresupuestoDao{

	public SolicitudReasignacionPresupuestoImp() {
        super();
        setClazz(SolicitudReasignacionPresupuesto.class);
    }

}
