package com.gdf4.framework.util;

import java.util.Random;

public class RandNumGen {
	
	//initiallize rand
	private static Random rand = new Random();
	
	//gen rand num between x and y
	public static int getRandIntBetween(int lower, int higher) {
		return rand.nextInt(higher - lower) + lower;	//get higer-lower first, then +lower
	}
	
	//get rand int between x and 0
	public static int getRandInt(int higher) {
		return rand.nextInt(higher);	//get rand int between x and 0
	}
	
}
