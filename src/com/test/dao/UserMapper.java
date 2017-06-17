/**
 * 2016年12月10日 下午11:17:11
 */
package com.test.dao;

import java.util.List;

import com.test.model.entity.TrUserEntity;
import com.test.model.value.user.CreateUserCondValue;
import com.test.model.value.user.EditUserCondValue;
import com.test.model.value.user.UserCondValue;
import com.test.model.value.user.UserListCondValue;

/**
 * @author Esion
 *
 */
public interface UserMapper {
	/**
	 * 获取用户信息(通过用户ID)
	 * 
	 * @param userAccount
	 * @param userPassword
	 * @return
	 */
	TrUserEntity getUserById(UserCondValue userCondValue);

	/**
	 * 获取用户信息(通过用户账号)
	 * 
	 * @param userGetCondValue
	 * @return
	 */
	TrUserEntity getUserByName(UserCondValue userCondValue);

	/**
	 * 获取所有用户数量
	 * 
	 * @return
	 */
	int getUserCount();

	/**
	 * 获取所有用户信息(数据分页)
	 * 
	 * @param userListCondValue
	 * @return
	 */
	List<TrUserEntity> getUserList(UserListCondValue userListCondValue);

	/**
	 * 添加用户
	 * 
	 * @param registerCondValue
	 */
	void addUser(CreateUserCondValue createUserCondValue);

	/**
	 * 修改用户
	 * 
	 * @param editUserDetailCondValue
	 */
	void editUser(EditUserCondValue editUserCondValue);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 */
	void deleteUserByUserId(String userId);

}
