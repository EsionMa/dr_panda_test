/**
 * 2017年1月21日 下午5:17:40
 */
package com.test.model.value.user;

/**
 * @author Esion
 *
 */
public class UserCondValue {
	/** 用户ID */
	private String userId;
	/** 用户名 */
	private String userName;

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

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCondValue [userId=" + userId + ", userName=" + userName + "]";
	}

}
