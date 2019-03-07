package kr.co.sist.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class ShaUtil {
	
	private static Base64 base64 = new Base64();

	public static String shaEncoding(String plaintext) {
		String ciphertext = "";

		// 평문의 값이 있을 때만 실행하기.
		if (plaintext != null || !"".equals(plaintext)) {

			try {
				// 1. 알고리즘을 사용할 수 있는 객체 얻기.
				MessageDigest md = MessageDigest.getInstance("SHA-1");

				// 2. 평문을 암호문으로 변경.
				md.update(plaintext.getBytes());

				// 3. 변환된 암호문을 얻기.
				ciphertext = new String(base64.encode(md.digest()));

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} // end catch
		} // end if

		return ciphertext;
	}// shaEncoding

}// class
