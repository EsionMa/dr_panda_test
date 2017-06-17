/**
 * 2016年12月10日 下午10:44:54
 */
package com.test.model.value.user;

/**
 * @author Esion
 *
 */
public class UserValue {
	/** 用户ID */
	private String userId;
	/** 用户名 */
	private String userName;
	/** 密码 */
	private String password;
	/** Cookie密码 */
	private String cookiePwd;
	/** 姓 */
	private String lastName;
	/** 名 */
	private String firstName;
	/** 创建时间 */
	private String createTime;

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

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName 要设置的 lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName 要设置的 firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime 要设置的 createTime
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserValue [userId=" + userId + ", userName=" + userName + ", password=" + password + ", cookiePwd=" + cookiePwd + ", lastName=" + lastName + ", firstName=" + firstName + ", createTime=" + createTime + "]";
	}

}
