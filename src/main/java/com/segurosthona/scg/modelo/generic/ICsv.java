package com.segurosthona.scg.modelo.generic;

/**
 * @author OWL
 *
 */
public interface ICsv {

	/**
	 * Return the Fields names for CSV representation
	 * @return
	 */
	String getFields();
	
	/**
	 * Returns field values for CSV representation
	 * @return
	 */
	String getValues();
}
