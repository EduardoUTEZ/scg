package com.segurosthona.scg.modelo.generic;

import java.io.Serializable;
import java.util.List;

public interface IPaginate<T extends Serializable> {

	/**
	 * Gets all objects from DB using provided pagination parameters
	 * @param pagingRequest
	 * @return list with all objects
	 */
	public List<T> findAll(PagingRequest pagingRequest);
		
}
