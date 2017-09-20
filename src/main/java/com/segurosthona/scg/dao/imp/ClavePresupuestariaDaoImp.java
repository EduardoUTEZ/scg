package com.segurosthona.scg.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.segurosthona.scg.controller.beans.ClavePresupuestariaList;
import com.segurosthona.scg.dao.ClavePresupuestariaDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.ClavePresupuestaria;




/**
 * Implementación del acceso a datos del repositorio de ClavePresupuestarias
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class ClavePresupuestariaDaoImp  extends AbstractHibernateDao<ClavePresupuestaria> implements ClavePresupuestariaDao{

	public ClavePresupuestariaDaoImp() {
        super();
        setClazz(ClavePresupuestaria.class);
    }

	@Override
	public List<ClavePresupuestariaList> getClaves() {
		StringBuilder queryx = new StringBuilder("Select new ");
		queryx.append("com.segurosthona.scg.controller.beans.ClavePresupuestariaList(c.id, c.empresa.nombre,");
		queryx.append(" concat( c.nivel1,' ', c.nivel2,' ', c.nivel3,' ', c.nivel4,' ', c.nivel5,' ', c.nivel6,' ', c.nivel7,' ', c.nivel8,' ', c.nivel9,' ', c.nivel10) ");
		queryx.append(",c.descripcion, c.cuentaContable) ");
		queryx.append("from ClavePresupuestaria c ");		
		Query query = getCurrentSession().createQuery(queryx.toString());		
		
		return query.list();
	}

	
	@Override
	public List<ClavePresupuestariaList> getCuentasPresupuestales() {
		StringBuilder queryx = new StringBuilder("Select new ");
		queryx.append("com.segurosthona.scg.controller.beans.ClavePresupuestariaList(c.id,");
		queryx.append(" concat( c.nivel1,' ', c.nivel2,' ', c.nivel3,' ', c.nivel4,' ', c.nivel5,' ', c.nivel6,' ', c.nivel7,' ', c.nivel8,' ', c.nivel9,' ', c.nivel10))");
		
		queryx.append("from ClavePresupuestaria as c");		
		Query query = getCurrentSession().createQuery(queryx.toString());		
		
		return query.list();
	}
	
	
	@Override
	public List<ClavePresupuestariaList> getClaves(Integer idEmpresa,
			Integer anio) {
		System.out.println("AÑO = "+anio);
		
		StringBuilder queryx = new StringBuilder("Select new ");
		queryx.append("com.segurosthona.scg.controller.beans.ClavePresupuestariaList(c.id, c.empresa.nombre,");
		queryx.append(" concat( c.nivel1,' ', c.nivel2,' ', c.nivel3,' ', c.nivel4,' ', c.nivel5,' ', c.nivel6,' ', c.nivel7,' ', c.nivel8,' ', c.nivel9,' ', c.nivel10) ");
		queryx.append(",c.descripcion, c.cuentaContable, c.anio) ");
		queryx.append("from ClavePresupuestaria c ");	
		queryx.append("where c.empresa.id=:idEmpresa and c.anio = :anio");	
		Query query = getCurrentSession().createQuery(queryx.toString());
		query.setParameter("idEmpresa", idEmpresa);
		query.setParameter("anio", anio);
		
		return query.list();
	}
}
