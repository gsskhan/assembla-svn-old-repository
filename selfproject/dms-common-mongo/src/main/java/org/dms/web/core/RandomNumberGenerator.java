package org.dms.web.core;

import java.util.Date;
import java.util.Random;

public class RandomNumberGenerator {
	
	private Random random;
	
	public long getRandomLong(){
		int posRandInt = random.nextInt(Integer.MAX_VALUE );
		return (new Date().getTime()+ posRandInt) ;
	}
	
	public int getRandomInt(){
		int posRandInt = random.nextInt(Integer.MAX_VALUE );
		return posRandInt;
	}

	public Random getRandom() {
		return random;
	}
	
	public void setRandom(Random random) {
		this.random = random;
	}
	
	

}
