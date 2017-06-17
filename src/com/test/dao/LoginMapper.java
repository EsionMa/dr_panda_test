/**
 * 2016年12月10日 下午11:17:11
 */
package com.test.dao;

import com.test.model.entity.TrLoginEntity;
import com.test.model.value.login.AddLoginCondValue;
import com.test.model.value.login.EditLoginCondValue;

/**
 * @author Esion
 *
 */
public interface LoginMapper {

	TrLoginEntity getLoginInfo(String userId);

	void addLogin(AddLoginCondValue addLoginCondValue);

	void editLogin(EditLoginCondValue editLoginCondValue);

	void deleteLogin(String userId);
}
