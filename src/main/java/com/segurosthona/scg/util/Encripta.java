package com.segurosthona.scg.util;

import java.security.*;
/**
 * Encripta.java
 *
 * Realiza una encriptación de datos para las claves.
 *
 * @author Miguel Figueroa Salgado
 *
 * @version 1.00 2008/01/13
 */
public class Encripta{
	
	public static String encripta(String claveAccesoCifrada){
		try{
				byte[] digest;								// Digest de MD5
				StringBuffer hexString = null;				// Buffer de la Clave de Acceso criptada
				
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(claveAccesoCifrada.getBytes());
				digest = md.digest();
				
				hexString = new StringBuffer();
				
				for(int i = 0; i < digest.length; i++) {
					claveAccesoCifrada = Integer.toHexString(0xFF & digest[i]);
					
					if(claveAccesoCifrada.length() < 2) {
						claveAccesoCifrada = "0" + claveAccesoCifrada;
					}
					
					hexString.append(claveAccesoCifrada);
				}
				claveAccesoCifrada = hexString.toString();
				md.reset();
				return claveAccesoCifrada;
					
			}catch(NoSuchAlgorithmException nsae){
				return "";
			}
	}
	
}