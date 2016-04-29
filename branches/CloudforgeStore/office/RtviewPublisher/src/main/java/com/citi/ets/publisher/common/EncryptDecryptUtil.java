package com.citi.ets.publisher.common;

import com.sun.crypto.provider.SunJCE;
import java.security.Key;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author gk85985
 * Class with methods to encrypt or decrypt a string.
 *
 */

public class EncryptDecryptUtil {
	                                                                     
	static String cryptKey = "$%&A3DES{Zaxkl}dmf-158965";
	static Key mKey;
	static String mKeyAlgorithm = "DESede";
	static String mCipherAlgorithm = "DESede/ECB/PKCS5Padding";
	static Cipher mCipher;
	static BASE64Decoder b64decoder;
	static BASE64Encoder b64encoder;
	
	
	/**
	 * @param cryptKey
	 * @throws Exception
	 */
	static void initialize() throws Exception {
		if (cryptKey.length() < 24)
			throw new Exception("key is too short! Key length must be 24 bytes");
		Security.addProvider(new SunJCE());
		byte[] arrayOfByte = cryptKey.getBytes();
		DESedeKeySpec localDESedeKeySpec = new DESedeKeySpec(arrayOfByte);
		SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance(mKeyAlgorithm);
		mKey = localSecretKeyFactory.generateSecret(localDESedeKeySpec);
		mCipher = Cipher.getInstance(mCipherAlgorithm);	
		b64encoder = new BASE64Encoder();
		b64decoder = new BASE64Decoder();		
	}
	
	/**
	 * To encrypt a string
	 * @param strToEncrypt
	 * @return String
	 * @throws Exception 
	 */
	public static String encrypt(String strToEncrypt) throws Exception { 
		initialize();
		mCipher.init(Cipher.ENCRYPT_MODE, mKey);
		byte[] encryptArrOfByte = mCipher.doFinal(strToEncrypt.getBytes());
		return b64encoder.encode(encryptArrOfByte);
	}
	
	/**
	 * To decrypt a string
	 * @param strToDecrypt
	 * @return String
	 * @throws Exception 
	 */
	public static String decrypt(String strToDecrypt) throws Exception { 
		initialize();
		mCipher.init(Cipher.DECRYPT_MODE, mKey);
		byte[] decodedArrOfByte = b64decoder.decodeBuffer(strToDecrypt);
		byte[] decryptArrOfByte = mCipher.doFinal(decodedArrOfByte);
		return new String(decryptArrOfByte);
	}
	

}
