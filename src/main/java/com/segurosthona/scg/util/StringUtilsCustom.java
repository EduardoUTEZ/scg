package com.segurosthona.scg.util;

import java.math.BigDecimal;

public class StringUtilsCustom {
	
	
	public static String repeat(String str, int times){		
		return new String(new char[times]).replace("\0", str);		
	}
	
	/**
	 * Format a string to be aligned to the left of a string with a fixed size. Unoccupied positions are filled with a trailing character.
	 * Eg.  formatAlignToLeft("hello", ".", 10) --> "hello....."
	 * @param str String to be formatted
	 * @param trailinChar filling character
	 * @param size fixed desired size
	 * @return
	 */
	public static String formatAlignToLeft(String str, String trailinChar, int size){
		str = str.trim();
		if(str.length() > size) throw new IllegalArgumentException("Original value is too big to be formatted.");
		return (str + repeat(trailinChar, size)).substring(0, size) ;		
	}
	public static String formatAlignToLeft(String str, String trailinChar, int size, boolean trim){
		if(str.length() > size) str = str.substring(0, size);
		return formatAlignToLeft(str, trailinChar, size);
	}	

	/**
	 * Format a string to be aligned to the right of a string with a fixed size. Unoccupied positions are filled with a trailing character.
	 * Eg.  formatAlignToRight("hello", ".", 10) --> ".....hello"
	 * @param str String to be formatted
	 * @param trailinChar filling character
	 * @param size fixed desired size
	 * @return
	 */	
	public static String formatAlignToRight(String str, String trailinChar, int size){
		str = str.trim();
		if(str.length() > size) throw new IllegalArgumentException("Original value is too big to be formatted.");
		return (repeat(trailinChar, size) + str).substring(str.length()) ;		
	}
	public static String formatAlignToRight(String str, String trailinChar, int size, boolean trim){
		if(str.length() > size) str = str.substring(0, size);
		return formatAlignToRight(str, trailinChar, size);
	}
	
	/**
	 * Format a BigDecimal to a String representation with a fixed size and fixed number of decimals, without decimal point
	 * Eg.: 1,240.87 --> formatNumber(1,240.87, 10, 3) --> 0001240870
	 * @param amount Big decimal to be formatted
	 * @param size desired total length of the output string (including decimals)
	 * @param decimals number of decimals (exceding decimals are truncated)
	 * @return String representation
	 * @throws IllegalArgumentException In case that the passed size is not enough to represent the integer part.
	 */
	public static String formatNumber(BigDecimal amount, int size, int decimals ) throws IllegalArgumentException{		
		int len = size;
		String decimalStr = "";
		if(decimals > 0){
			decimalStr = amount.remainder(BigDecimal.ONE).toPlainString().split("\\.")[1];
			if(decimalStr.length() > decimals){
				decimalStr = decimalStr.substring(0, decimals);
			}
			else{
				decimalStr = StringUtilsCustom.formatAlignToRight(decimalStr, "0", decimals);
			}
			len -= decimals;
		}
		
		String integerStr = String.valueOf(amount.longValue());
		if(integerStr.length() > len){ 
			throw new IllegalArgumentException("The integer part is bigger than the passed size.");
		}
		integerStr = StringUtilsCustom.formatAlignToRight(integerStr, "0", len);
		
		StringBuilder str = new StringBuilder(integerStr);
		if(!decimalStr.isEmpty()) str.append(decimalStr);
		
		return str.toString();
	}	
	
	/**
	 * Join an array as a String using a separator among elements 
	 * @param aArr Array to be joined
	 * @param sSep separator that will be used
	 * @return
	 */
	public static String join(String[] aArr, String sSep) {
	    StringBuilder sbStr = new StringBuilder();
	    for (int i = 0, il = aArr.length; i < il; i++) {
	        if (i > 0)
	            sbStr.append(sSep);
	        sbStr.append(aArr[i]);
	    }
	    return sbStr.toString();
	}	
	
	
	/**
     *	Metodo filtro que realiza un ajuste a la derecha
     *	con el valor de tamaño y caracter de relleno.
     *
     *	@param	dato	Dato fuente al que se le realiza el ajuste.
     *	@param	tam		Tamaño al que se ajusta el dato fuente.
     *	@param	re		Caracter o cadena de relleno para el campo.
     *	@return 		dato ajustado al tamaño tam usando re como relleno.
     *
     */
     public static String reDer(String dato, int tam, String re){
     	if(dato == null)
     		dato = "";
     		
     	if(dato.length()>tam){
     		dato = dato.substring(0, tam);
     	}

     	int datoLength = dato.length();
     	String datoSalida = dato;

     	for(int i=datoLength; i<tam; i++){
     		datoSalida = datoSalida +re;
     	}
     	return datoSalida;
     }
     
     /**
      *	Metodo filtro que realiza un ajuste a la izquierda
      *	con el valor de tamaño y caracter de relleno.
      *
      *	@param	dato	Dato fuente al que se le realiza el ajuste.
      *	@param	tam		Tamaño al que se ajusta el dato fuente.
      *	@param	re		Caracter o cadena de relleno para el campo.
      *	@return 		dato ajustado al tamaño tam usando re como relleno.
      *
      */
      public static String reIzq(String dato, int tam, String re){
      	if(dato == null)
      		dato = "";
      		
      	if(dato.length()>tam){
      		dato = dato.substring(0, tam);
      	}

      	int datoLength = dato.length();
      	String datoSalida = dato;

      	for(int i=datoLength; i<tam; i++){
      		datoSalida =re + datoSalida;
      	}
      	return datoSalida;
      }
	
	
}
