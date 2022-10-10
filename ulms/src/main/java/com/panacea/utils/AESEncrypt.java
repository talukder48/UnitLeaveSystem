package com.panacea.utils;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;


public class AESEncrypt {
	private static String secretKey = "The Dark Horse";
	private static String salt = "Panacea";
	 
	public static String encrypt(String strToEncrypt) 
	{
	    try
	    {
	        byte[] iv = { 'T', 'H', 'E', 'R', 'E', 'A', 'L', 'D', 'A', 'R', 'K', 'H', 'O', 'R', 'S', 'E'};
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65535, 128);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKeyS = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKeyS, ivspec);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
}
