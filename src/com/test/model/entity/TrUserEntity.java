/**
 * 2017年3月11日 下午2:40:21
 */
package com.test.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Esion
 *
 */
public class TrUserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4228699608109649300L;
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
	private Timestamp createTime;

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
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime 要设置的 createTime
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
