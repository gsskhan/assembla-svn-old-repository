package com.citi.retail.optima.etl.common.mail.util;

import java.io.File;

/**
 * This class is defined for mail content VO. 
 * It defines and sets all required information for sending email notifications.
 * @author sv16441
 *
 */
public class MailContentVO {
	private String senderAddress;
	private String receiverAddress;
	private String subjectInfo;
	private String mailContent;
	private File attachments;
	/**
	 * @return the senderAddress
	 */
	public String getSenderAddress() {
		return senderAddress;
	}
	/**
	 * @param senderAddress the senderAddress to set
	 */
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	
	/**
	 * @return the receiverAddress
	 */
	public String getReceiverAddress() {
		return receiverAddress;
	}
	/**
	 * @param receiverAddress the receiverAddress to set
	 */
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	/**
	 * @return the subjectInfo
	 */
	public String getSubjectInfo() {
		return subjectInfo;
	}
	/**
	 * @param subjectInfo the subjectInfo to set
	 */
	public void setSubjectInfo(String subjectInfo) {
		this.subjectInfo = subjectInfo;
	}
	/**
	 * @return the mailContent
	 */
	public String getMailContent() {
		return mailContent;
	}
	/**
	 * @param mailContent the mailContent to set
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	/**
	 * @return the attachments
	 */
	public File getAttachments() {
		return attachments;
	}
	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(File attachments) {
		this.attachments = attachments;
	}

}
