package com.citi.cawp.common;

import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Logger;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SLLUtil {
	
	private static Logger log = Logger.getLogger(SLLUtil.class.getName());

	
	  @SuppressWarnings("restriction")
	public static void doTrustCertificates() throws Exception {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {			
				return null;
			}
			public void checkServerTrusted(X509Certificate[] arg0, String arg1) 
					throws CertificateException {
			}
			public void checkClientTrusted(X509Certificate[] arg0, String arg1)
					throws CertificateException {
			}
		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
					log.warning("url host '" + urlHostName
							+ "' is different to SSLSession host '"
							+ session.getPeerHost() + "'.");
				}
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}
	
	/**
	 * X509TrustManager has been replaced in jdk 7 onwards with X509ExtendedTrustManager
	 * 
	@SuppressWarnings("restriction")
	public static void doTrustCertificates() throws Exception {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		TrustManager[] trustAllCerts = new TrustManager[] { new X509ExtendedTrustManager() {			
			
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			
			
			public void checkServerTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				
			}
			
			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType,
					SSLEngine engine) throws CertificateException {
				
			}
			
			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType,
					Socket socket) throws CertificateException {
				
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType,
					SSLEngine engine) throws CertificateException {
				
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType,
					Socket socket) throws CertificateException {
				
			}
		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
					log.warning("url host '" + urlHostName
							+ "' is different to SSLSession host '"
							+ session.getPeerHost() + "'.");
				}
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}*/ 

}
