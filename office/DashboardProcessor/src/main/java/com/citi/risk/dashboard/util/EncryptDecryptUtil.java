package com.citi.risk.dashboard.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import com.citi.risk.dashboard.exception.EncryDecryException;
import com.sun.crypto.provider.SunJCE;

/**
 * 
 * @author gk85985 Class with methods to encrypt or decrypt a string.
 * 
 */
@SuppressWarnings("restriction")
public final class EncryptDecryptUtil {

    private static String cryptKey = "$%&A3DES{Zaxkl}dmf-158965";
    private static Key mKey;
    private static String mKeyAlgorithm = "DESede";
    private static String mCipherAlgorithm = "DESede/ECB/PKCS5Padding";
    private static Cipher mCipher;
    private static BASE64Decoder b64decoder;
    private static BASE64Encoder b64encoder;

    private EncryptDecryptUtil() {
        super();
    }

    /**
     * @param cryptKey
     * @throws GeneralSecurityException
     * @throws Exception
     */
    static void initialize() throws GeneralSecurityException {
        if (cryptKey.length() < 24) {
            throw new EncryDecryException(
                    "key is too short! Key length must be 24 bytes");
        }
        Security.addProvider(new SunJCE());
        byte[] arrayOfByte = cryptKey.getBytes();
        DESedeKeySpec localDESedeKeySpec = new DESedeKeySpec(arrayOfByte);
        SecretKeyFactory localSecretKeyFactory = SecretKeyFactory
                .getInstance(mKeyAlgorithm);
        mKey = localSecretKeyFactory.generateSecret(localDESedeKeySpec);
        mCipher = Cipher.getInstance(mCipherAlgorithm);
        b64encoder = new BASE64Encoder();
        b64decoder = new BASE64Decoder();
    }

    /**
     * To encrypt a string
     * 
     * @param strToEncrypt
     * @return String
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws Exception
     */
    public static String encrypt(String strToEncrypt)
            throws GeneralSecurityException {
        initialize();
        mCipher.init(Cipher.ENCRYPT_MODE, mKey);
        byte[] encryptArrOfByte = mCipher.doFinal(strToEncrypt.getBytes());
        return b64encoder.encode(encryptArrOfByte);
    }

    /**
     * To decrypt a string
     * 
     * @param strToDecrypt
     * @return String
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String strToDecrypt)
            throws GeneralSecurityException, IOException {
        initialize();
        mCipher.init(Cipher.DECRYPT_MODE, mKey);
        byte[] decodedArrOfByte = b64decoder.decodeBuffer(strToDecrypt);
        byte[] decryptArrOfByte = mCipher.doFinal(decodedArrOfByte);
        return new String(decryptArrOfByte);
    }

    public static String getCryptKey() {
        return cryptKey;
    }

    public static Key getmKey() {
        return mKey;
    }

    public static String getmKeyAlgorithm() {
        return mKeyAlgorithm;
    }

    public static String getmCipherAlgorithm() {
        return mCipherAlgorithm;
    }

    public static Cipher getmCipher() {
        return mCipher;
    }

    public static BASE64Decoder getB64decoder() {
        return b64decoder;
    }

    public static BASE64Encoder getB64encoder() {
        return b64encoder;
    }
}
