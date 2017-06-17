/**
 * 
 */
package com.test.utility;

import java.util.Random;

/**
 * @author Edison
 *
 */
public class UserIdUtility {
	/** 用户ID标识符U */
	private static final String ID = "U";

	/** ID字符源 */
	private static final String BASE_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * 生成用户ID
	 * 
	 * @return
	 */
	public static String generateUserId() {

		String hexTime = Long.toHexString(DateUtility.getCurrentTimestamp().getTime()).toUpperCase();

		StringBuilder sb = new StringBuilder();
		sb.append(ID);
		sb.append(hexTime);

		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int number = random.nextInt(BASE_WORD.length());
			sb.append(BASE_WORD.charAt(number));
		}

		return sb.toString();
	}
}
