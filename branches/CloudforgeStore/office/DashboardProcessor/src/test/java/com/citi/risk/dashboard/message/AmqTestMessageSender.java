package com.citi.risk.dashboard.message;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.UUID;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AmqTestMessageSender {

	public static void main(String[] args) {
		System.out.println("Start sending TEXT Message to AMQ local.");
		
		try{
			// Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("TESTQUEUE");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);

            // Create a messages
            String text = getXmlAsString();
            TextMessage message = session.createTextMessage(text);
            message.setJMSCorrelationID(UUID.randomUUID().toString());
            /*
            BytesMessage message = (BytesMessage) session.createBytesMessage();
            message.writeBytes("Hello".getBytes());
            */

            // Tell the producer to send the message
            producer.send(message);
            System.out.println("Sent message: "+ message);            

            // Clean up
            session.close();
            connection.close();
		} catch (Exception e){
			System.err.println("Error in sending jms text message.");
			e.printStackTrace();
			
		}
	}
	
	public static String getXmlAsString(){
		String xmlString = "";
		try {
			FileReader fr = new FileReader("src/main/resources/sample/Response.xml");
			BufferedReader br  = new BufferedReader(fr);
			StringBuilder strbuilder = new StringBuilder();
			String line ="";
			while ((line = br.readLine()) != null) {
				strbuilder.append(line);
			}
			xmlString = strbuilder.toString();
			br.close();
			
		} catch (Exception e) {
			System.err.println("Error in reading file.");
			e.printStackTrace();
		}
		return xmlString;
	}

}
