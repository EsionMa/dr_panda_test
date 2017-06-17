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
public class TrLoginEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4728069472580995946L;
	/** 用户ID */
	private String userId;
	/** 状态 */
	private String loginStatus;
	/** 登录时间 */
	private Timestamp loginTime;

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
	public Timestamp getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime 要设置的 loginTime
	 */
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

}
