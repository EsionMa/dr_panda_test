/**
 * 2016年12月10日 下午11:41:09
 */
package com.test.service;

import com.test.model.value.user.EditUserCondValue;
import com.test.model.value.user.UserListCondValue;
import com.test.model.value.user.UserListValue;

/**
 * @author Esion
 *
 */
public interface IUserService {
	/**
	 * 获取所有用户信息列表(数据分页)
	 * 
	 * @param UserListCondValue
	 * @return
	 * @throws Exception
	 */
	public UserListValue getUserList(UserListCondValue UserListCondValue) throws Exception;

	// /**
	// * 获取用户信息(通过用户ID)
	// *
	// * @param userGetCondValue
	// * @return
	// * @throws Exception
	// */
	// public UserDetailValue getUserDetailById(UserDetailCondValue
	// userDetailCondValue) throws Exception;

	/**
	 * 编辑用户详细
	 * 
	 * @throws Exception
	 */
	public void editUserInfo(EditUserCondValue editUserCondValue) throws Exception;

	public void deleteUserInfo(String userIdFsFs);
}
