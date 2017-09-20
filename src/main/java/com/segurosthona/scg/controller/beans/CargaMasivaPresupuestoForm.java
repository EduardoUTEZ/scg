package com.segurosthona.scg.controller.beans;

import org.springframework.web.multipart.MultipartFile;

public class CargaMasivaPresupuestoForm {

	private MultipartFile file = null;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
}
