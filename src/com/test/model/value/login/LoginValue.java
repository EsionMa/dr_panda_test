/**
 * LoginInfoValue.java
 * 
 * 2017
 * 
 * Esion
 */
package com.test.model.value.login;

/**
 * @author Esion
 *
 */
public class LoginValue {
	private String userId;
	private String loginStatus;
	private String loginTime;

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
	 * @return loginStatus
	 */
	public String getLoginStatus() {
		return loginStatus;
	}

	/**
	 * @param loginStatus 要设置的 loginStatus
	 */
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	/**
	 * @return loginTime
	 */
	public String getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime 要设置的 loginTime
	 */
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginValue [userId=" + userId + ", loginStatus=" + loginStatus + ", loginTime=" + loginTime + "]";
	}

}
