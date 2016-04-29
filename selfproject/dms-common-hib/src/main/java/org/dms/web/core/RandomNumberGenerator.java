package org.dms.web.core;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

public class RandomNumberGenerator {
	
	@Autowired
	private Random random;
	
	public long getRandomLong(){
		int posRandInt = random.nextInt(Integer.MAX_VALUE );
		return (new Date().getTime()+ posRandInt) ;
	}

	public Random getRandom() {
		return random;
	}
	
	public void setRandom(Random random) {
		this.random = random;
	}
	
	

}
