package com.citi.retail.optima.etl.batch.job.processor.da;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("itemProcessor")
@Scope(value = "step")
public class DBProcessor implements ItemProcessor<String[], String[]> {

	@Value("#{stepExecutionContext[name]}")
	private String threadName;

	
	//private MessageDigest md = null;
	
	
	@Override
	public String[] process(String[] item) throws Exception {
		return item;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	
	
	/**
	 * 
	 * @param nextRecord
	 * @param position
	 * @return
	 *//*
	private String[] encriptData(String[] nextRecord, int position)
	{
		byte[] digest;
		String data, byteString;
		data = nextRecord[position];

		try {
			if (StringUtils.isNotEmpty(data)) { // encrypt data
				md.reset();
				md.update(data.getBytes());
				digest = md.digest();
				StringBuffer hexString = new StringBuffer();
				for (int i=0;i<digest.length;i++) {
					String hex=Integer.toHexString(0xff & digest[i]);
					if(hex.length()==1) hexString.append('0');
					hexString.append(hex);
				}
				byteString = new String(hexString);
				nextRecord[position] = byteString;
			}
		} catch (Exception e) {
			System.out.println("ERROR: Error occured while encripting data");
			e.printStackTrace();
		}

		return nextRecord;
	}*/


}
