package org.demo.ws;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;

public class SoapWSClientTwo {
	
    /*
    Constructed SOAP Request Message:
    <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
        <SOAP-ENV:Header/>
        <SOAP-ENV:Body>
            <example:VerifyEmail xmlns:example="http://ws.cdyne.com/">
                <example:email>mutantninja@gmail.com</example:email>
                <example:LicenseKey>123</example:LicenseKey>
            </example:VerifyEmail>
        </SOAP-ENV:Body>
    </SOAP-ENV:Envelope>
     */
	
	public static Logger log = Logger.getLogger(SoapWSClientTwo.class.getName());

	public static void main(String[] args) {
		// set the MessageFactory System property
		// System.setProperty("javax.xml.soap.MessageFactory", "com.sssw.jbroker.saaj.soap.MessageFactoryImpl");
		// set the ConnectionFactory System property
		// System.setProperty("javax.xml.soap.SOAPConnectionFactory", "com.sssw.jbroker.saaj.soap.SOAPConnectionFactoryImpl");
		    
		log.info("program started ...");
		try {
			// First create the connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			URL destination = new URL("https://ws.cdyne.com/emailverify/Emailvernotestemail.asmx");
			
			// Next, create the actual message
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();
			
			SOAPPart soapPart = message.getSOAPPart();
			SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
			
			// To set HTTP and SOAP headers (Optional).
            MimeHeaders mimeHeaders = message.getMimeHeaders();
            mimeHeaders.addHeader("Content-Type", "text/xml; charset=UTF-8");
            
            // To remove the Soap Header (Optional)
            SOAPHeader soapHeader = soapEnvelope.getHeader();
            soapHeader.detachNode();
            
            // Create and populate the body
            SOAPBody soapBody = soapEnvelope.getBody();
            
            	// Create the main element and namespace
            	SOAPElement bodyElement = soapBody.addChildElement("VerifyEmail", "example", "http://ws.cdyne.com/");
            	SOAPElement childElementOne = bodyElement.addChildElement("email", "example");
            				childElementOne.addTextNode("g.s.s.khan@gmail.com");
            	SOAPElement childElementTwo = bodyElement.addChildElement("LicenseKey", "example");
            				childElementTwo.addTextNode("123");
            	
            // Save the message
            message.saveChanges();	
            
            // Print the request message 
            log.info("Request SOAP Message:");
            //message.writeTo(System.out);
            log.info("\n" +getSOAPMessageAsString(message));
            
            // For SSL bypass (Optional)
            doTrustToCertificates();
            
            // Send the message and get the reply
            SOAPMessage reply = soapConnection.call(message, destination);
            
            // print SOAP reply
            log.info("Response SOAP Message:");
            log.info("\n"+ getSOAPMessageAsString(reply));
			
						
		} catch (Exception e) {
			log.error("error in calling WS.", e);
		}
	}
	
	public static String getSOAPMessageAsString(SOAPMessage soapMessage) {
	      try {

	         TransformerFactory tff = TransformerFactory.newInstance();
	         Transformer tf = tff.newTransformer();
	         String strMessage = "";

	         // Set formatting	        
	         tf.setOutputProperty(OutputKeys.INDENT, "yes");
	         tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	         
	         Iterator<?> itr = soapMessage.getMimeHeaders().getAllHeaders();
	         while (itr.hasNext()) {
				MimeHeader mimeHeader = (MimeHeader) itr.next();
				strMessage = strMessage + mimeHeader.getName()+":"+mimeHeader.getValue()+"\n";				
	         } 

	         Source sc = soapMessage.getSOAPPart().getContent();

	         ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
	         StreamResult result = new StreamResult(streamOut);
	         tf.transform(sc, result);

	         strMessage = strMessage + streamOut.toString();
	         return strMessage;
	      } catch (Exception e) {
	         log.error("Exception in getSOAPMessageAsString ", e);
	         return null;
	      }

	}
	
	/*
	 *
	 *Code from http://blog.hexican.com/2010/12/sending-soap-messages-through-https-using-saaj/
	 *Code from http://ruelajingsantiago.wordpress.com/2013/08/16/saaj-web-service-client-over-ssl/
	 *
	 */
	
	static public void doTrustToCertificates() throws Exception {
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			TrustManager[] trustAllCerts = new TrustManager[]{
					new X509TrustManager() {
						
						@Override
						public X509Certificate[] getAcceptedIssuers() {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public void checkServerTrusted(X509Certificate[] arg0, String arg1)
								throws CertificateException {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void checkClientTrusted(X509Certificate[] arg0, String arg1)
								throws CertificateException {
							// TODO Auto-generated method stub
							
						}
					}
			};
	 
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HostnameVerifier hv = new HostnameVerifier() {		
				@Override
				public boolean verify(String urlHostName, SSLSession session) {
					if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
						log.warn("Warning: URL host '" + urlHostName + "' is different to SSLSession host '"
									+ session.getPeerHost() + "'.");
					}
					return true;				 
				}
			};
			HttpsURLConnection.setDefaultHostnameVerifier(hv);	 
	}

}
