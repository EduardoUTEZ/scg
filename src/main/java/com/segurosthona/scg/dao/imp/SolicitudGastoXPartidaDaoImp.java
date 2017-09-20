package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.GastosDao;
import com.segurosthona.scg.dao.RolDao;
import com.segurosthona.scg.dao.SolicitudGastoXPartidaDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.Gastos;
import com.segurosthona.scg.modelo.entidad.Rol;
import com.segurosthona.scg.modelo.entidad.SolicitudGastoXPartida;




/**
 * Implementación del acceso a datos del repositorio de Roles
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class SolicitudGastoXPartidaDaoImp  extends AbstractHibernateDao<SolicitudGastoXPartida> implements SolicitudGastoXPartidaDao{

	public SolicitudGastoXPartidaDaoImp() {
        super();
        setClazz(SolicitudGastoXPartida.class);
    }
}
