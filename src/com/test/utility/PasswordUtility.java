/**
 * 2017年3月22日 上午11:53:14
 */
package com.test.utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

/**
 * @author Esion
 *
 */
public class PasswordUtility {

	private static final String BASE_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * 生成CookiePassword
	 * 
	 * @return
	 */
	public static String generateCookiePassword() {

		StringBuilder sb = new StringBuilder();

		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int number = random.nextInt(BASE_WORD.length());
			sb.append(BASE_WORD.charAt(number));
		}

		return sb.toString();
	}

	/**
	 * MD5加密
	 * 
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();

		String newstr = base64en.encode(md5.digest(str.getBytes("UTF-8")));
		return newstr;
	}

	/**
	 * 密码验证
	 * 
	 * @param password
	 * @param md5Password
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static boolean checkPassword(String password, String md5Password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (EncoderByMd5(password).equals(md5Password))
			return true;
		else
			return false;
	}

}