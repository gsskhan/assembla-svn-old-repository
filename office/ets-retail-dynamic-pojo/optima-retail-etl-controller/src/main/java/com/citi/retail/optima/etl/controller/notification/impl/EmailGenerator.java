package com.citi.retail.optima.etl.controller.notification.impl;


import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import  com.citi.retail.optima.etl.controller.model.MailDetailsVO;
//import org.apache.log4j.Logger;

//import com.citi.optima.da.utils.DADateUtils;

public class EmailGenerator
{
		//private static Logger logger = Logger.getLogger(SendMail.class);
		private JavaMailSender mailSender;
	    
	 
		public void setMailSender(JavaMailSender mailSender) {
			this.mailSender = mailSender;
		}

		
		/**
		 * Used to split the email addresses
		 * 
		 * @param addresses
		 * @return
		 */
		private String[] splitEmailAddress(String addresses)
		{
			String internetAddress = null;
			String[] internetAddressList = new String[addresses.split(";").length];
			int count = 0;
			for (String address : addresses.split(";")) {

				if (address != null && !address.isEmpty()) {
					try {
						internetAddress = new String(address);
						internetAddressList[count++] = internetAddress;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return internetAddressList;
		}
		
		public void sendMail(MailDetailsVO mailDetailsVO) {
	        
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(mailDetailsVO.getSender());
			message.setTo(splitEmailAddress(mailDetailsVO.getRecipient()));
			message.setSubject(mailDetailsVO.getMsgSubject());
			message.setText(mailDetailsVO.getMsgBody());
	        try {
	            this.mailSender.send(message);

	        } catch (MailException ex) {
	        	//ex.printStackTrace();
	        }
	    }
		
	 
}