package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.BitacoraReasignacionDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.BitacoraReasignacion;




/**
 * Implementación del acceso a datos del repositorio de BitacoraReasignacion
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class BitacoraReasignacionImp  extends AbstractHibernateDao<BitacoraReasignacion> implements BitacoraReasignacionDao{

	public BitacoraReasignacionImp() {
        super();
        setClazz(BitacoraReasignacion.class);
    }

}
