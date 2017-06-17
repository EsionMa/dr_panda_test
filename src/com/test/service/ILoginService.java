/**
 * 2017年3月25日 下午4:55:49
 */
package com.test.service;

import com.test.model.value.UserLoginValue;
import com.test.model.value.login.AddLoginCondValue;
import com.test.model.value.login.EditLoginCondValue;
import com.test.model.value.login.LoginValue;
import com.test.model.value.user.UserValue;

/**
 * @author Esion
 *
 */
public interface ILoginService {
	public UserValue login(UserLoginValue userLoginValue) throws Exception;

	public LoginValue getLoginInfo(String userId) throws Exception;

	public void addLogin(AddLoginCondValue addLoginCondValue) throws Exception;

	public void editLogin(EditLoginCondValue editLoginCondValue) throws Exception;

	public void deleteLogin(String userId) throws Exception;
}
