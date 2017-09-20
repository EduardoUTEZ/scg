package com.segurosthona.scg.dao.imp;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.segurosthona.scg.controller.beans.BusquedaBitacoraForm;
import com.segurosthona.scg.dao.BitacoraAccesoDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.BitacoraAcceso;

/**
 * Implementación del acceso a datos del repositorio de BitacoraAccesos
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 * 
 */
@Repository
public class BitacoraAccesoDaoImp extends AbstractHibernateDao<BitacoraAcceso>
		implements BitacoraAccesoDao {

	public BitacoraAccesoDaoImp() {
		super();
		setClazz(BitacoraAcceso.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.segurosthona.scg.dao.BitacoraAccesoDao#getBitacorasAcceso(java.util
	 * .Date, java.util.Date)
	 */
	@Override
	public List<BitacoraAcceso> getBitacorasAcceso(BusquedaBitacoraForm busqueda) {
		List<BitacoraAcceso> result = null;
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("from BitacoraAcceso where fechaAcceso >= :f1 and fechaAcceso <= :f2");
		try {
			Query query = getCurrentSession().createQuery(
					queryBuilder.toString());
			
			//Agrega 1 día para abir el intervalo.
			Calendar cal = Calendar.getInstance();
			cal.setTime(busqueda.getF2());
			cal.add(Calendar.DATE, 1);
			
			query.setParameter("f1", busqueda.getF1());
			query.setParameter("f2", cal.getTime());

			result = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return result;
	}

}
