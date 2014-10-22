package controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.soap.*;

import com.exony.resourcemanagement.access.XMLBufferedReader;

public class Test {
	
	private static String url = "https://172.31.14.195:8085/ResourceManagement";
	
	public static void main(String args[]) throws Exception {
		// Create SOAP Connection
//		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//		SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		// Send SOAP Message to SOAP Server 
		String file="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:res=\"http://www.exony.com/schemas/2009/10/resourcemanagement\"><soap:Header xmlns:wsa=\"http://www.w3.org/2005/08/addressing\"><wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsu:Timestamp wsu:Id=\"&quot;TS-0&quot;\"><wsu:Created>2014-10-17T14:06:08.181+02:00</wsu:Created><wsu:Expires>2014-10-17T14:16:08.181+02:00</wsu:Expires></wsu:Timestamp><wsse:UsernameToken wsu:Id=\"&quot;UsernameToken-0&quot;\"><wsse:Username>administrator</wsse:Username><wsse:Password>C1sco123</wsse:Password></wsse:UsernameToken></wsse:Security><wsa:Action>Create</wsa:Action><wsa:To>https://172.31.14.195:8085/ResourceManagement</wsa:To></soap:Header><soap:Body><Create xmlns=\"http://www.exony.com/schemas/2009/10/resourcemanagement\"><resources><Resource><Identity>-1</Identity><Type>User</Type><EffectiveFrom>0001-01-01T00:00:00</EffectiveFrom><EffectiveTo>2079-06-06T00:00:00.0000000</EffectiveTo><Status>R</Status><Changestamp>0</Changestamp><Fields><NameValuePair><Name>FolderId</Name><Value>6b88d0aa-c8de-4b9c-9538-64946c560cc0</Value></NameValuePair><NameValuePair><Name>LoginName</Name><Value>testUser</Value></NameValuePair></Fields><Custom xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/></Resource></resources></Create></soap:Body></soap:Envelope>";
//		SOAPMessage soapResponse = soapConnection.call(getSoapMessageFromString(file), url);
		
		
		//------------------------------------------------------------------
		HttpsURLConnection connection = trustedHTTPSConnection();
		//Provide connection with required properties
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type","application/soap+xml;charset=UTF-8;action=\"create:User\"");

		SOAPMessage command = getSoapMessageFromString(file);
		
		System.out.println("***************EXECUTE 2");
		// Write command to https connection
		command.writeTo(new DataOutputStream(connection.getOutputStream()));
		command.writeTo(System.out);
		System.out.println("***************EXECUTE HEAD*************\n"+command.getSOAPHeader().getTextContent());
		System.out.println("***************EXECUTE BODY*************\n" + command.getSOAPPart().getEnvelope().getTextContent());
//		System.out.println("******SOAP to String*********\n" + this.soapMessageToString(command));
		
		//Get Reponse
		InputStream is;
		try{
			System.out.println("*******BEFORE Exception1*************");
			InputStream iss = connection.getInputStream();
			System.out.println("*******BEFORE Exception2*************");
			is = checkXMLAndExtractBody(iss, true);
		}catch (IOException e){
		// print SOAP Response
		System.out.print("Response SOAP Message:");
//		soapResponse.writeTo(System.out);
//
//		
//		soapConnection.close();
	}
	}

	/**
	 * The .Net XML APIs that push data from the server have no problem pushing out XML that does not meet the XML 1.0 spec.
	 * Therefore we need to check for this before the inputstream from the https connection gets processed.
	 */
	private static InputStream checkXMLAndExtractBody(InputStream is, boolean extractBody) throws IOException{
		StringBuffer buffer = new StringBuffer();

		System.out.println("*******check0********");
		XMLBufferedReader br = new XMLBufferedReader(new InputStreamReader(is), 5);
		System.out.println("*******check1********");
		
		char[] cBuffer = new char[1];
		while(cBuffer.length > 0){
			cBuffer = br.readAsCharArray();
			buffer.append(cBuffer);
		}
		
		br.close();
		String buf = buffer.toString();
		
		if (extractBody){
			buf = buf.split("<s:Body>")[1];
			buf = buf.split("</s:Body>")[0];
		}
		System.out.println("*******check2********");
		return new ByteArrayInputStream(buf.getBytes());
	}


	private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(),
				new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
		return message;
	}


	
	private static SOAPMessage createSOAPRequest() throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String serverURI = "http://ws.cdyne.com/";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("example", serverURI);

		/*
		 * Constructed SOAP Request Message: 
		 * <SOAP-ENV:Envelope
		 * xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
		 * xmlns:example="http://ws.cdyne.com/"> 
		 * <SOAP-ENV:Header/>
		 * <SOAP-ENV:Body> 
		 * <example:VerifyEmail>
		 * <example:email>mutantninja@gmail.com</example:email>
		 * <example:LicenseKey>123</example:LicenseKey> 
		 * </example:VerifyEmail>
		 * </SOAP-ENV:Body> </SOAP-ENV:Envelope>
		 */

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("VerifyEmail", "example");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("email", "example");
		soapBodyElem1.addTextNode("mutantninja@gmail.com");
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("LicenseKey", "example");
		soapBodyElem2.addTextNode("123");

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "VerifyEmail");

		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;
	}
	
	/**
	 * Method to create a HTTPS connection without requiring a certificate.
	 * This method should not be employed in general use.
	 */
	private static HttpsURLConnection trustedHTTPSConnection() throws Exception{
		TrustManager[] trustAllCerts = new TrustManager[]{
			    new X509TrustManager() {
			        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			            return null;
			        }
			        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType){}
			        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType){}
			    }
			};
		
		//-------- ADDED ----------------
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				System.out.println("[ResourceManagementConnectionHelper] Warning: Certificate Verification Skipped. URL Host: " + urlHostName
						+ " vs. " + session.getPeerHost());
				return true;
			}
		};
		
	    SSLContext sc = SSLContext.getInstance("SSL");
	    sc.init(null, trustAllCerts, new java.security.SecureRandom());
	    HttpsURLConnection.setDefaultHostnameVerifier(hv);  // ADDED
 	    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		return (HttpsURLConnection) (new URL(url)).openConnection();
	}

	
	public String soapMessageToString(SOAPMessage message) {
		String result = null;

		if (message != null) {
			ByteArrayOutputStream baos = null;
			try {
				baos = new ByteArrayOutputStream();
				message.writeTo(baos);
				result = baos.toString();
			} catch (Exception e) {
			} finally {
				if (baos != null) {
					try {
						baos.close();
					} catch (IOException ioe) {
					}
				}
			}
		}
		return result;
	}

}
