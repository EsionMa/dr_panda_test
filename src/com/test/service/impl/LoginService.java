/**
 * 2017年3月25日 下午4:56:55
 */
package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.LoginMapper;
import com.test.dao.UserMapper;
import com.test.model.entity.TrLoginEntity;
import com.test.model.entity.TrUserEntity;
import com.test.model.value.UserLoginValue;
import com.test.model.value.login.AddLoginCondValue;
import com.test.model.value.login.EditLoginCondValue;
import com.test.model.value.login.LoginValue;
import com.test.model.value.user.UserCondValue;
import com.test.model.value.user.UserValue;
import com.test.service.ILoginService;
import com.test.utility.DateUtility;
import com.test.utility.PasswordUtility;
import com.test.utility.StringUtility;

/**
 * @author Esion
 *
 */
@Service
public class LoginService implements ILoginService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private LoginMapper loginMapper;

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbs.service.ILoginService#login(com.bbs.model.info.UserLoginInfo)
	 */
	@Override
	public UserValue login(UserLoginValue userLoginValue) throws Exception {
		UserValue userValue = new UserValue();
		String userId = userLoginValue.getUserId();
		String userName = userLoginValue.getUserName();
		// 用户密码
		String password = userLoginValue.getPassword();
		// Cookie密码
		String cookiePwd = userLoginValue.getCookiePwd();
		UserCondValue userCondValue = new UserCondValue();
		TrUserEntity trUserEntity = null;
		if (StringUtility.isEmptyAfterTrim(userId)) {
			// 手动登录（用户账号登录）
			userCondValue.setUserName(userName);
			trUserEntity = userMapper.getUserByName(userCondValue);
			if (trUserEntity != null) {
				// 检验登录密码
				if (!PasswordUtility.checkPassword(password, trUserEntity.getPassword())) {
					throw new Exception("账号或密码不正确");
				}
			} else {
				throw new Exception("该账号未注册");
			}
		} else {
			// 自动登录（用户ID登录）
			userCondValue.setUserId(userId);
			trUserEntity = userMapper.getUserById(userCondValue);
			if (trUserEntity != null) {
				// 检验Cookie密码
				if (!cookiePwd.equals(trUserEntity.getCookiePwd())) {
					throw new Exception("登录已失效，请重新登录");
				}
			}
		}
		if (trUserEntity != null) {
			userValue.setUserId(trUserEntity.getUserId());
			userValue.setCreateTime(DateUtility.toStringDate("yyyy-MM-dd HH:mm:ss", trUserEntity.getCreateTime()));
		}
		// 判断当前是否只存在一个session
		LoginValue loginValue = getLoginInfo(trUserEntity.getUserId());
		if (loginValue != null) {
			if (loginValue.getLoginStatus().equals("0")) {
				EditLoginCondValue editLoginCondValue = new EditLoginCondValue();
				editLoginCondValue.setUserId(trUserEntity.getUserId());
				editLoginCondValue.setLoginStatus("1");
				editLogin(editLoginCondValue);
			} else {
				throw new Exception("该账号已在其它设备上登录");
			}
		} else {
			// 第一次登录
			AddLoginCondValue addLoginCondValue = new AddLoginCondValue();
			addLoginCondValue.setUserId(trUserEntity.getUserId());
			addLoginCondValue.setLoginStatus("1");
			addLoginCondValue.setLoginTime(DateUtility.getCurrentTimestamp());
			addLogin(addLoginCondValue);
		}
		return userValue;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.test.service.ILoginService#getLoginInfo(java.lang.String)
	 */
	@Override
	public LoginValue getLoginInfo(String userId) throws Exception {
		LoginValue loginValue = null;
		TrLoginEntity trLoginEntity = loginMapper.getLoginInfo(userId);
		if (trLoginEntity != null) {
			loginValue = new LoginValue();
			loginValue.setUserId(trLoginEntity.getUserId());
			loginValue.setLoginStatus(trLoginEntity.getLoginStatus());
			loginValue.setLoginTime(DateUtility.toStringDate("yyyy-MM-dd HH:mm:ss", trLoginEntity.getLoginTime()));
		}
		return loginValue;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.test.service.ILoginService#addLogin(com.test.model.value.login.
	 * AddLoginCondValue)
	 */
	@Override
	public void addLogin(AddLoginCondValue addLoginCondValue) throws Exception {
		loginMapper.addLogin(addLoginCondValue);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.test.service.ILoginService#editLogin()
	 */
	@Override
	public void editLogin(EditLoginCondValue editLoginCondValue) throws Exception {
		TrLoginEntity trLoginEntity = loginMapper.getLoginInfo(editLoginCondValue.getUserId());
		if (trLoginEntity != null) {
			loginMapper.editLogin(editLoginCondValue);
		} else {
			throw new Exception("该账户不存在");
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.test.service.ILoginService#deleteLogin(java.lang.String)
	 */
	@Override
	public void deleteLogin(String userId) throws Exception {
		TrLoginEntity trLoginEntity = loginMapper.getLoginInfo(userId);
		if (trLoginEntity != null) {
			loginMapper.deleteLogin(userId);
		} else {
			throw new Exception("该账户不存在");
		}
	}

}
