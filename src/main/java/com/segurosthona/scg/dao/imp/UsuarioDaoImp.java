package com.segurosthona.scg.dao.imp;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.UsuarioDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.Usuario;




/**
 * Implementación del acceso a datos del repositorio de Usuarios
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class UsuarioDaoImp  extends AbstractHibernateDao<Usuario> implements UsuarioDao{

	public UsuarioDaoImp() {
        super();
        setClazz(Usuario.class);
    }

	/*
	 * (non-Javadoc)
	 * @see com.segurosargos.scg.dao.UsuarioDao#getUsuario(java.lang.String)
	 */
	@Override
	public Usuario getUsuario(String correoElectronico) {
		
		Usuario result = null;
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("from Usuario where correoElectronico= :correoElectronico");		
		try {
			Query query = getCurrentSession()
					.createQuery(queryBuilder.toString());
			
			query.setParameter("correoElectronico", correoElectronico);
			
			result =   (query.list().size()>0?(Usuario)query.list().get(0):null);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see com.segurosargos.scg.dao.UsuarioDao#getUsuarioPorNombreAcceso(java.lang.String)
	 */
	@Override
	public Usuario getUsuarioPorNombreAcceso(String nombreAcceso) {
		Usuario result = null;
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("from Usuario where nombreAcceso= :nombreAcceso");		
		try {
			Query query = getCurrentSession()
					.createQuery(queryBuilder.toString());
			
			query.setParameter("nombreAcceso", nombreAcceso);
			
			result =   (query.list().size()>0?(Usuario)query.list().get(0):null);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return result;
	}
}
