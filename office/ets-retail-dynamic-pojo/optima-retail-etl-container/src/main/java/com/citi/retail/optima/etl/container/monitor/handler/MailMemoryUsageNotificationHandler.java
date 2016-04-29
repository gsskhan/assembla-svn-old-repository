package com.citi.retail.optima.etl.container.monitor.handler;

import java.lang.management.MemoryType;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailMemoryUsageNotificationHandler extends
		AbstractMemoryUsageNotificationListener {

	private String jmxHost;
	private Integer jmxPort;
	private MessageChannel mailChannel;

	public MailMemoryUsageNotificationHandler(String name) {
		super(name);
	}

	public void setJmxHost(String jmxHost) {
		this.jmxHost = jmxHost;
	}

	public void setJmxPort(Integer jmxPort) {
		this.jmxPort = jmxPort;
	}

	public void setMailChannel(MessageChannel mailChannel) {
		this.mailChannel = mailChannel;
	}

	@Override
	public void exceedUsageThreshold(MemoryType memoryType, long max, long used)
			throws Exception {

		MimeMessage message = prepareMimeMessage(memoryType, max, used);
		this.mailChannel.send(MessageBuilder.withPayload(message).build());
	}

	private MimeMessage prepareMimeMessage(MemoryType memoryType, long max,
			long used) throws MessagingException {
		String subject = (new StringBuilder("Memory Usage Exceeded (type:"))
				.append(memoryType.name()).append(", host:")
				.append(MailMemoryUsageNotificationHandler.this.jmxHost)
				.append(", port:")
				.append(MailMemoryUsageNotificationHandler.this.jmxPort)
				.append(")").toString();

		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props);

		MimeMessageHelper helper = new MimeMessageHelper(new MimeMessage(
				session), true, "UTF-8");
		helper.setSubject(subject);
		helper.setText("<h2>" + memoryType.name()
				+ " Memory Usage Exceeded Warning</h2>", true);

		return helper.getMimeMessage();
	}
}
