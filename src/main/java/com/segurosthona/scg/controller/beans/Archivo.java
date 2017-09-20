package com.segurosthona.scg.controller.beans;

import org.springframework.web.multipart.MultipartFile;

/**
 * Contiene un archivo para su carga al sistema.
 * 
 * @author Miguel Figueoroa Salgado
 *
 */
public class Archivo {
	
	private MultipartFile archivo;

	public MultipartFile getArchivo() {
		return archivo;
	}

	public void setArchivo(MultipartFile archivo) {
		this.archivo = archivo;
	}	
	
}
