package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class EncrptDataUtils {

	public static String encrpt(String plain){
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] cipherBytes = md.digest(plain.getBytes());
			
			BASE64Encoder encoder = new BASE64Encoder();
			String ciper = encoder.encode(cipherBytes);
			return ciper;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}
}
