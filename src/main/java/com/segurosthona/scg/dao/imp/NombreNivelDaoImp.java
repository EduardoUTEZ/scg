package com.segurosthona.scg.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.NombreNivelDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.NombreNivel;




/**
 * Implementación del acceso a datos del repositorio de NombreNivel
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class NombreNivelDaoImp  extends AbstractHibernateDao<NombreNivel> implements NombreNivelDao{

	public NombreNivelDaoImp() {
        super();
        setClazz(NombreNivel.class);
    }

	/*
	 * (non-Javadoc)
	 * @see com.segurosthona.scg.dao.NombreNivelDao#getByEmpresa(java.lang.Integer)
	 */
	@Override
	public NombreNivel getByEmpresa(Integer idEmpresa) {
		StringBuilder queryx = new StringBuilder("from NombreNivel where idEmpresa = :idEmpresa");
		Query query = getCurrentSession().createQuery(queryx.toString());
		
		query.setParameter("idEmpresa", idEmpresa);
		List<NombreNivel> nombres = query.list();
		
		return (nombres != null && nombres.size()>0?nombres.get(0):null);
	}
}
