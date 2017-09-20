package com.segurosthona.scg.dao.generic;

import java.io.Serializable;

import com.segurosthona.scg.modelo.generic.IOperations;




/**
 * Interfase para las operaciones genéricas del acceso a datos, incluye por extensión 
 * las operaciones genéricas CRUD
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> Tipo de la clase a la que se asocian las operaciones gen�ricas de modelo
 */
public interface IGenericDao<T extends Serializable> extends IOperations<T> {
    //
}