package kr.co.sist.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class ShaUtil {
	
	private static Base64 base64 = new Base64();

	public static String shaEncoding(String plaintext) {
		String ciphertext = "";

		// ���� ���� ���� ���� �����ϱ�.
		if (plaintext != null || !"".equals(plaintext)) {

			try {
				// 1. �˰����� ����� �� �ִ� ��ü ���.
				MessageDigest md = MessageDigest.getInstance("SHA-1");

				// 2. ���� ��ȣ������ ����.
				md.update(plaintext.getBytes());

				// 3. ��ȯ�� ��ȣ���� ���.
				ciphertext = new String(base64.encode(md.digest()));

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} // end catch
		} // end if

		return ciphertext;
	}// shaEncoding

}// class
