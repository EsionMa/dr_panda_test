/**
 * 2017年3月23日 上午11:01:38
 */
package com.test.model.value;

/**
 * @author Esion
 *
 */
public class UserLoginValue {
	/** 用户ID */
	private String userId;
	/** 用户名 */
	private String userName;
	/** 用户密码 */
	private String password;
	/** Cookie密码 */
	private String cookiePwd;

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
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return cookiePwd
	 */
	public String getCookiePwd() {
		return cookiePwd;
	}

	/**
	 * @param cookiePwd 要设置的 cookiePwd
	 */
	public void setCookiePwd(String cookiePwd) {
		this.cookiePwd = cookiePwd;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserLoginValue [userId=" + userId + ", userName=" + userName + ", password=" + password + ", cookiePwd=" + cookiePwd + "]";
	}

}
