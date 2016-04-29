package com.citi.ets.jms;

/*
 * =================================================================
 * Copyright (c) 2001-2003 TIBCO Software Inc.
 * All rights reserved.
 * For more information, please contact:
 * TIBCO Software Inc., Palo Alto, California, USA
 *
 * $RCSfile: catejmsjnditest.java,v $
 * $Revision: 1.1 $
 * $Date: 2007/10/01 17:37:53 $
 * =================================================================
 */

/* This has been modified from tibjmsJNDI.java by Bill Olik and Ignacio Lopez*/
/*
 * Example of how to use JNDI to lookup administered objects
 * from a TIBCO Enterprise Message Service client.
 *
 * There are four types of administered objects:
 *   - TopicConnectionFactory
 *   - QueueConnectionFactory
 *   - Topic
 *   - Queue
 *
 * TIBCO Enterprise Message Service provides the ability to lookup
 * those administered objects using the TIBCO Enterprise Message Service
 * server as a JNDI provider.
 *
 * Note that TIBCO Enterprise Message Service's JNDI interface only
 * allows lookup of static topics and queues. Static topics and queues are
 * those which have direct entries in the topics and queues configuration
 * files. On the contrary, dynamic topics and queues are created
 * by the applications using wildcard matching and the rules of
 * properties inheritance and do not have explicit entries in the
 * configuration files.
 *
 * Also note that JNDI lookup of topics and queues may fail if
 * the configuration contains a topic and a queue with the same name.
 * In this case the application should use name qualifiers such as
 * $topics and $queues as to qualify as demonstrated by this sample.
 *
 * This sample assumes the use of the original sample configuration
 * files distributed with TIBCO Enterprise Message Service software. If the
 * configuration is altered this sample may not work as expected.
 *
 *
 * Usage:  java catejmsjnditest  [-provider <providerUrl>]
 *
 *    where options are:
 *
 *      -provider   Provider URL used for JNDI access
 *                  to administered objects.
 *                  If not specified this sample assumes a
 *                  providerUrl of "tibjmsnaming://localhost:7222"
 *
 *
 */


import javax.jms.*;
import javax.naming.*;
import java.util.*;

/*
* These are components required to add SSL support to the client
*/
import java.security.*;  
import com.tibco.tibjms.naming.*;

public class catejmsjnditestQueue
       implements ExceptionListener, MessageListener
{
    static final String  providerContextFactory =
                            "com.tibco.tibjms.naming.TibjmsInitialContextFactory";
    static final String  defaultProviderURL = null;
                                            //"tibjmsnaming://localhost:7222";
    /* 
     * 	Added default SSProviderURL for SSL Support
     */ 
    static final String  defaultSSLProviderURL = null;
                                            //"ssl://localhost:7243";
	/*
	* Variable declaration
	*/
    String      providerUrl     = "ssl://gftsuat.nam.nsroot.net:7243";
    String      userName        = "etsdashboard_167254";
    String      password        = null;
    String      queueName       = "ot.ets.na.ETSDashboard_167254.request";
    String      queueCF         = "ot.ets.na.ETSDashboard_167254.QueueCF";
    MessageConsumer msgConsumer = null;
    int         msgNumber       = 0;
    boolean     receiveMsg      = false;

	/*
	* Variable declaration for SSL
	*/
    Vector      ssl_trusted              = new Vector();
    String      ssl_identity             = "src\\main\\resources\\certs\\etsdashboard_167254.p12";
    String      ssl_key                  = null;
    String      ssl_password             = "CitiRisk@2014";
    String      ssl_keypass              = "CitiRisk@2014";
    String      ssl_vendor               = "j2se";
    boolean     SSLFlag			 		 = true;
    boolean     ssl_trace                = true;
    boolean     ssl_debug_trace          = false;
    boolean     disable_verify_host_name = false;
    boolean     disable_verify_host      = false;

    /**
     * The following method creates a java.Security.SecureRandom object 
     * seeded with the current time.  It allows the samples that use SSL to 
     * initialize the SSL environment much faster than if they had to 
     * generate a truly random seed.
     *
     * NOTE: THIS SHOULD NOT BE USED IN A PRODUCTION ENVIRONMENT AS IT IS
     *       NOT SECURE.
     */
     /*public static SecureRandom createUnsecureRandom()
             throws JMSSecurityException {
        try {
        	SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");    	
           
              * jl38129 the following lines generates a Secure Random Number
              * without using the current time.
               
        	byte[] bytes = new byte[1024/8];
        	sr.nextBytes(bytes);
        	int seedByteCount = 10;
        	byte[] seed = sr.generateSeed(seedByteCount);
        	sr = SecureRandom.getInstance("SHA1PRNG");
        	sr.setSeed(seed);
            //sr.setSeed(System.currentTimeMillis()); 
        	return sr;
        } catch(NoSuchAlgorithmException e) {
          JMSSecurityException jmse =
                new JMSSecurityException("Error creating SecureRandom object: " + e.getMessage());
          jmse.setLinkedException(e);
          throw jmse;
        }
    }*/

    public catejmsjnditestQueue(String[] args) {

        parseArgs(args);

        // jl38129  check for the SSL flag
          if (providerUrl == null) {
             if (! SSLFlag) 
               providerUrl = defaultProviderURL;
   	     else 
               providerUrl = defaultSSLProviderURL;
          }

        System.err.println("Using JNDI with TIBCO EMS sample.");
        System.err.println("Using server: "+providerUrl);

       Hashtable env = new Hashtable();
       /*
        * initialize SSL environment if requiered
        */ 
       if (providerUrl.indexOf("ssl://") >= 0) {
    	   // if (SSLFlag){
    	   try {
		       if (userName != null) {
	                  env.put(Context.SECURITY_PRINCIPAL, userName);
	
	                  if (password != null)
	                     env.put(Context.SECURITY_CREDENTIALS, password);
	           }
		       /*
		       	* set SSL vendor
		        */
	            if (ssl_vendor != null) {
	                  env.put(TibjmsContext.SSL_VENDOR, ssl_vendor);
	            }
	
	           /*
	            * set trace for client-side operations, loading of certificates
	            * and other
	            */
	
	           if (ssl_trace) { 
	              env.put(TibjmsContext.SSL_TRACE, new Boolean(true));
	           } 
	
	       		/* 
	       		 * Set vendor trace. Has no effect for "j2se", "entrust6" uses
	       		 * this to trace SSL handshake
	       		 */
	       
	           if (ssl_debug_trace) {
	              env.put(TibjmsContext.SSL_DEBUG_TRACE, new Boolean(true));
	           }

	           /*
	            * Set trusted certificates if specified 
	            */
	           if (ssl_trusted.size() != 0) {
	              env.put(TibjmsContext.SSL_TRUSTED_CERTIFICATES, ssl_trusted);
	           }

               /*
				*  Set client identity if specified. ssl_key may be null
				*  if identity is PKCS12, JKS or EPF. 'j2se' only supports
				*  PKCS12 and JKS. 'entrust6' also supports PEM and PKCS8.
 				*/
               if (ssl_identity != null) {
                  if (ssl_password == null) {
                     System.err.println("Error: must specify -ssl_password if identity is set");
                     System.exit(-1);
                  }
                  env.put(TibjmsContext.SSL_IDENTITY, ssl_identity);
                  env.put(TibjmsContext.SSL_PASSWORD, ssl_password);
                  env.put("com.tibco.tibjms.ssl.password", ssl_keypass);
                  if (ssl_key != null)
                     env.put(TibjmsContext.SSL_PRIVATE_KEY, ssl_key);
               }

		       if (disable_verify_host_name) {
	                  env.put(TibjmsContext.SSL_ENABLE_VERIFY_HOST_NAME, new Boolean(false));
	           }

               if (disable_verify_host || ssl_trusted.size()==0) {
                  env.put(TibjmsContext.SSL_ENABLE_VERIFY_HOST, new Boolean(false));
               }
               env.put(TibjmsContext.SECURITY_PROTOCOL, "ssl");
               env.put(TibjmsContext.SSL_CIPHER_SUITES, "RC4-MD5");
               
               /*
                * Installs a random number generator which is fast but not secure!
                */
               //com.tibco.tibjms.TibjmsSSL.setSecureRandom(createUnsecureRandom());
    	   }
	  	   catch(Exception e) {
	            e.printStackTrace();
	            if (e instanceof JMSException) {
	               JMSException je = (JMSException)e;
	               if (je.getLinkedException() != null) {
	                  System.err.println("##### Linked Exception:");
	                  je.getLinkedException().printStackTrace();
	               }
	        	}
	        	System.exit(-1);
	  	   }
       } // Finish SSL environment initialization.

       try
        {
            /*
             * Initialize the JNDI Context.
             */
            env.put(Context.INITIAL_CONTEXT_FACTORY, providerContextFactory);
            env.put(Context.PROVIDER_URL, providerUrl);

            InitialContext jndiContext = new InitialContext(env);

            
          
   
            /*
             * Lookup queue connection factory which must exist in the
             * factories configuration file.
             */
            QueueConnectionFactory queueFactory =
           (QueueConnectionFactory)jndiContext.lookup(queueCF);
            System.err.println("OK - successfully did lookup of " + queueCF + ", " + queueFactory);

          

        	/*
           	* Lookup queue, which must exist in the queues configuration 
        	* file of JNDI and broker, if not successful then it is most
           	* likely that such queue does not exist in the configuration files
        	*/

            javax.jms.Queue sampleQueue = null;

            try
            {
                sampleQueue =
                    (javax.jms.Queue)jndiContext.lookup(queueName);
                System.err.println("OK - successfully did lookup queue '" + queueName + "'");
            }
            catch(NamingException ne)
            {
                System.err.println("**NamingException occurred while lookup the queue" + queueName);
                System.err.println("  Most likely such queue does not exist in your configuration.");
                System.err.println("  Exception message follows:");
                System.err.println(ne.getMessage());
                System.exit(0);
            }

 
            /*
             * Let's create a queue connection to the server and a session to
             * verify the server is running so we can continue with our lookup
             * operations.
             */
            QueueConnection queueConnection = null;
            QueueSession    queueSession    = null;

            try
            {
                if (providerUrl.indexOf("ssl://") >= 0) {

                    /*
            		* Set the password key for the keystore returned by the JNDI
            		*/
                    char[] sslpassword = ssl_keypass.toCharArray();
                    com.tibco.tibjms.TibjmsSSL.setPassword(sslpassword);

                    /*
            		* Ignore username/password for SSL Connection since 
            		* certificate based authentication is been used.
            		*/
                    queueConnection = queueFactory.createQueueConnection(userName,password);
                } else 
                    queueConnection = queueFactory.createQueueConnection(userName,password);

                queueSession    = queueConnection.createQueueSession(false,
                                        javax.jms.Session.AUTO_ACKNOWLEDGE);
        		/*
        		* Starting an asynchronous queue subscriber
        		*/                	
                System.err.println("Subscribing to Queue: "+queueName+ "'\n");
                msgNumber = 0;
                Subscriber(queueConnection, queueSession, sampleQueue);
                /* 
            	* Publishing messages to a Queue
            	*/
                System.err.println("Sending to queue '" + queueName + "'\n");
                
                /* 
                 * Creating the Queue sender 
                 */
                QueueSender queueSender = queueSession.createSender(sampleQueue);

                for (int i=0; i< 3; i++)
                {
                  javax.jms.TextMessage message = queueSession.createTextMessage();
                  String text = "This is a CATE test "+ (i+1);
                  message.setText(text);
                  queueSender.send(message);
                  System.err.println("Sent message: "+text);
                }
                  
                  while ( true ){
                      if (receiveMsg && msgNumber >= 3)
                      {                
                          queueConnection.close();
                          System.err.println("Connections Closed");
                          break;
                      }
                  }
            }
            catch(JMSException e)
            {
                System.err.println("**JMSException occurred while creating queue connection");
                System.err.println("  Most likely the server is not running, the exception trace follows:");
                e.printStackTrace();
                System.exit(0);  // can't lookup anything anyway
            }

            System.err.println("OK - Done.");

        }

        catch(NamingException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String args[])
    {
        new catejmsjnditestQueue(args);
    }

    /*---------------------------------------------------------------------
     * AsyncSubscriber
     *---------------------------------------------------------------------*/
    public void Subscriber(Connection subsConnection, Session subsSession, Destination destination)
    {
        try {
        	/*
        	 * Creates the consumer
        	 */
			
            msgConsumer = subsSession.createConsumer(destination);
            
            /*
             * Set the message listener
             */
            msgConsumer.setMessageListener(this);
   
            /*
             *  Start the connection
             */
            subsConnection.start();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    /*---------------------------------------------------------------------
    * onException
    *---------------------------------------------------------------------*/
    public void onException(JMSException e)
    {
        /* print the connection exception status */
        System.err.println("CONNECTION EXCEPTION: "+ e.getMessage());
    }

    /*---------------------------------------------------------------------
     * onMessage
     *---------------------------------------------------------------------*/
    public void onMessage(Message msg)
    {
        receiveMsg = false;
        try
        {
            msgNumber++ ;
            System.err.println("\nReceived message " + msgNumber + ":"  + msg );
            receiveMsg = true;
       }
        catch(Exception e)
        {
            System.err.println("Unexpected exception in the message callback!");
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    
    void usage()
    {
        System.err.println("\nUsage: java catejmsjnditestQueue [options]");
        System.err.println("");
        System.err.println("  where options are:");
        System.err.println("");
        System.err.println(" -provider  <provider URL>  - JNDI provider URL, default is local server");
        System.err.println(" -user      <user name>     - user name, default is null");
        System.err.println(" -password  <password>      - password, default is null");
        System.err.println(" -qcf       <queue CF name> - queue connection factory");
        System.err.println(" -queue     <queue name>    - queue used for test");
        /*
         *  Usage for SSL options
         */
        System.err.println("  SSL options:");
        System.err.println(" -SSL                       - enable client for SSL");
        System.err.println(" -ssl_vendor    <name>      - SSL vendor: 'j2se' or 'entrust6',");
        System.err.println("                              default is 'j2se'");
        System.err.println(" -ssl_trace                 - trace SSL initialization");
        System.err.println(" -ssl_debug_trace           - trace SSL handshake and related");
        System.err.println(" -ssl_trusted  <file-name>  - file with trusted certificate(s),");
        System.err.println("                              this parameter may repeat if more");
        System.err.println("                              than one file required");
        System.err.println(" -ssl_identity <file-name>  - client identity file");
        System.err.println(" -ssl_key     <file-name>   - client key file (optional)");
        System.err.println(" -ssl_password   <string>   - password to decrypt client identity");
        System.err.println(" -ssl_keypass    <string>   - password to decrypt client identity");
        System.err.println("                              or key file");
        System.err.println(" -no_verify_host_name       - disable host name verification");
        System.err.println(" -no_verify_host            - disable host verification");
        System.err.println("");
        System.exit(0);
    }

    void parseArgs(String[] args)
    {
        int i=0;
        if (args.length == i)
        	usage();
        
        while(i < args.length)
        {
            if (args[i].compareTo("-provider")==0)
            {
                if ((i+1) >= args.length) usage();
                providerUrl = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-user")==0)
            {
                if ((i+1) >= args.length) usage();
                userName = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-password")==0)
            {
                if ((i+1) >= args.length) usage();
                password = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-queue")==0)
            {
                if ((i+1) >= args.length) usage();
                queueName = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-qcf")==0)
            {
                if ((i+1) >= args.length) usage();
                queueCF = args[i+1];
                i += 2;
            }
            /*
             *  Parsing of SSL options
             */
            else
            if (args[i].compareTo("-SSL")==0)
            {
		SSLFlag = true;
                i += 1;
            }
            else
            if (args[i].compareTo("-ssl_trace")==0)
            {
                ssl_trace = true;
                i += 1;
            }
            else
            if (args[i].compareTo("-ssl_debug_trace")==0)
            {
                ssl_debug_trace = true;
                i += 1;
            }
            else
            if (args[i].compareTo("-ssl_trusted")==0)
            {
                if ((i+1) >= args.length) usage();
                ssl_trusted.addElement(args[i+1]);
                i += 2;
            }
            else
            if (args[i].compareTo("-ssl_identity")==0)
            {
                if ((i+1) >= args.length) usage();
                ssl_identity = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-ssl_key")==0)
            {
                if ((i+1) >= args.length) usage();
                ssl_key = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-ssl_password")==0)
            {
                if ((i+1) >= args.length) usage();
                ssl_password = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-ssl_keypass")==0)
            {
                if ((i+1) >= args.length) usage();
                ssl_keypass = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-ssl_vendor")==0)
            {
                if ((i+1) >= args.length) usage();
                ssl_vendor = args[i+1];
                i += 2;
            }
            else
            if (args[i].compareTo("-no_verify_host_name")==0)
            {
                disable_verify_host_name = true;
                i += 1;
            }
            else
            if (args[i].compareTo("-no_verify_host")==0)
            {
                disable_verify_host = true;
                i += 1;
            }
            else
            if (args[i].compareTo("-help")==0)
            {
                usage();
            }
            else
            {
                System.err.println("Unrecognized parameter: "+args[i]);
                usage();
            }
        }
    }
}
