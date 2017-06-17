/**
 * 2017年3月11日 下午2:04:00
 */
package com.test.model.value.user;

import java.util.List;

import com.test.model.value.PageValue;

/**
 * @author Esion
 *
 */
public class UserListValue extends PageValue {
	/** 用户列表 */
	private List<UserValue> userList;

	/**
	 * @return userList
	 */
	public List<UserValue> getUserList() {
		return userList;
	}

	/**
	 * @param userList 要设置的 userList
	 */
	public void setUserList(List<UserValue> userList) {
		this.userList = userList;
	}

}
