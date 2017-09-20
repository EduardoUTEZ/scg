/**
 * 
 */
package com.segurosthona.scg.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;


public class Randomizer {

	
	private static Random rnd = new Random();

	public static int getNumRandom() {
		return rnd.nextInt();
	}

	public static String getNumSRandom() {
		return String.valueOf(rnd.nextInt());
	}

}
