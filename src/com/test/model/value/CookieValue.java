/**
 * 2017年3月21日 上午11:15:42
 */
package com.test.model.value;

/**
 * @author Esion
 *
 */
public class CookieValue {
	/** Cookie名 */
	private static final String COOKIE_NAME = "dr.panda.cookie";
	/** 用户ID */
	private String userId;
	/** 密码 */
	private String password;

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId 要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return cookieName
	 */
	public static String getCookieName() {
		return COOKIE_NAME;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CookieInfo [userId=" + userId + ", password=" + password + "]";
	}

}
