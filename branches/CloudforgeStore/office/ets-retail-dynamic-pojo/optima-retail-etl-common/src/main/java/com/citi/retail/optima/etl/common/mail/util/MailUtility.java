package com.citi.retail.optima.etl.common.mail.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 * This class defined for sending email notification.
 * 
 * @author sv16441
 * 
 */
public class MailUtility {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MailUtility.class);

	private MailSender mailSender;
	private JavaMailSender javaMailSender;
	private String senderAddress;
	private String receiverAddress;
	private String mailHost;

	/**
	 * @param mailHost
	 *            the mailHost to set
	 */
	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}

	private static final String EXCEED_THRESHOLD_NOTIFICATION_SUBJECT = "Exceeding memory usage: ";

	/**
	 * @param senderAddress
	 *            the senderAddress to set
	 */
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	/**
	 * @param receiverAddress
	 *            the receiverAddress to set
	 */
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	/**
	 * @param javaMailSender
	 *            the javaMailSender to set
	 */
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendSimpleEmail(MailContentVO mailContentVO) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom(mailContentVO.getSenderAddress() == null ? this.senderAddress
					: mailContentVO.getSenderAddress());
			msg.setTo(mailContentVO.getReceiverAddress() == null ? this.receiverAddress
					: mailContentVO.getReceiverAddress());
			msg.setSubject(mailContentVO.getSubjectInfo());
			msg.setText(mailContentVO.getMailContent());
			msg.setSubject(mailContentVO.getSubjectInfo());
			LOGGER.info("Before Sending Email Notification....");
			this.mailSender.send(msg);
			LOGGER.info("Mail Sent..");
		} catch (MailException ex) {
			LOGGER.error(ex.getMessage());
		}
	}

	public void sendMIMEEmail(final MailContentVO mailContentVO) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@Override
				public void prepare(MimeMessage mimeMessage)
						throws MessagingException {
					mimeMessage.setRecipient(
							Message.RecipientType.TO,
							new InternetAddress(mailContentVO
									.getReceiverAddress()));
					mimeMessage.setFrom(new InternetAddress(mailContentVO
							.getSenderAddress()));
					mimeMessage.setText(mailContentVO.getMailContent());
					mimeMessage.setSubject(mailContentVO.getSubjectInfo());
				}
			};
			{
				LOGGER.info("Before Sending Email Notification....");
				this.javaMailSender.send(preparator);
				LOGGER.info("Mail Sent..");
			}
		} catch (MailException ex) {
			LOGGER.error(ex.getMessage());
		}
	}

	public void sendSpecialAttachmentsEmail(MailContentVO mailContentVO) {
		try {
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			sender.setHost(this.mailHost);
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(mailContentVO.getSenderAddress() == null ? this.senderAddress
					: mailContentVO.getSenderAddress());
			helper.setTo(mailContentVO.getReceiverAddress() == null ? this.receiverAddress
					: mailContentVO.getReceiverAddress());
			helper.setSubject(mailContentVO.getSubjectInfo());
			helper.setText(mailContentVO.getMailContent());
			helper.setSubject(mailContentVO.getSubjectInfo());
			helper.addAttachment("Attachments ..",
					mailContentVO.getAttachments());
			LOGGER.info("Before Sending Email Notification....");
			sender.send(message);
			LOGGER.info("Mail Sent..");
		} catch (MailException mailEx) {
			LOGGER.error(mailEx.getMessage());
		} catch (MessagingException messEx) {
			LOGGER.error(messEx.getMessage());
		}
	}

	public void sendExceedUsageThresholdNotification(String memoryTypeName,
			long max, long used) {

		MailContentVO resp = new MailContentVO();
		resp.setSenderAddress(this.senderAddress);
		resp.setReceiverAddress(this.receiverAddress);
		resp.setSubjectInfo(EXCEED_THRESHOLD_NOTIFICATION_SUBJECT);
		resp.setMailContent("Exceeding memory usage: type=" + memoryTypeName
				+ ", max=" + max + ", used=" + used);
		sendMIMEEmail(resp);
	}

}
