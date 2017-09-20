package com.segurosthona.scg.dao.imp;

import org.springframework.stereotype.Repository;

import com.segurosthona.scg.dao.EmpresaDao;
import com.segurosthona.scg.dao.generic.AbstractHibernateDao;
import com.segurosthona.scg.modelo.entidad.Empresa;




/**
 * Implementación del acceso a datos del repositorio de Empresas
 * 
 * @author MFS - Miguel Figueroa Salgado
 * @version 1.0
 *
 */
@Repository
public class EmpresaDaoImp  extends AbstractHibernateDao<Empresa> implements EmpresaDao{

	public EmpresaDaoImp() {
        super();
        setClazz(Empresa.class);
    }
}
