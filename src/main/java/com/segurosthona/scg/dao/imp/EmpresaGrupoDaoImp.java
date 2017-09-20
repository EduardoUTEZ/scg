package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.EmpresaGrupoDao;
import com.segurosthona.scg.dao.RolDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.EmpresaGrupo;
import com.segurosthona.scg.modelo.entidad.Rol;




/**
 * Implementación del acceso a datos del repositorio de Roles
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class EmpresaGrupoDaoImp  extends AbstractHibernateDao<EmpresaGrupo> implements EmpresaGrupoDao{

	public EmpresaGrupoDaoImp() {
        super();
        setClazz(EmpresaGrupo.class);
    }
}
