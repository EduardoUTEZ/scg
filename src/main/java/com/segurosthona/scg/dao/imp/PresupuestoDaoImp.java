package com.segurosthona.scg.dao.imp;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.PresupuestoDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.Presupuesto;




/**
 * Implementación del acceso a datos del repositorio de Presupuestos
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class PresupuestoDaoImp  extends AbstractHibernateDao<Presupuesto> implements PresupuestoDao{

	public PresupuestoDaoImp() {
        super();
        setClazz(Presupuesto.class);
    }

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.segurosthona.scg.dao.PresupuestoDao#getByIdClavePresupuestal(java.lang.Integer)
	 */
	public List<Presupuesto> getByIdClavePresupuestal(Integer idClave) {
		StringBuilder queryx = new StringBuilder("from Presupuesto where idClavePresupuestaria = :idClave order by mes");
		Query query = getCurrentSession().createQuery(queryx.toString());
		query.setParameter("idClave", idClave);
		
		return query.list();
	}
}
