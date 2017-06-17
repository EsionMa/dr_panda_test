/**
 * 2017年2月26日 上午12:09:44
 */
package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.model.form.login.UserLoginForm;
import com.test.model.value.CookieValue;
import com.test.model.value.UserLoginValue;
import com.test.model.value.user.UserValue;
import com.test.service.ILoginService;
import com.test.utility.StringUtility;

/**
 * @author Esion
 *
 */
@Controller
public class LoginController extends CommonController {
	@Autowired
	private ILoginService loginService;

	/**
	 * 登录页面
	 * 
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login")
	public String showLogin(ModelMap modelMap) throws Exception {
		// UserLoginInfo userLoginInfo = new UserLoginInfo();
		// userLoginInfo.setUserAccount("admin");
		// userLoginInfo.setUserPassword("123456");
		// modelMap.put("userLoginInfo", userLoginInfo);
		return "login";
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param userLoginForm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "login/jump", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, UserLoginForm userLoginForm) throws Exception {
		UserLoginValue userLoginValue = new UserLoginValue();
		userLoginValue.setUserName(userLoginForm.getUserName());
		userLoginValue.setPassword(userLoginForm.getPassword());
		// 账号
		if (StringUtility.isEmptyAfterTrim(userLoginForm.getUserName())) {
			modelMap.put("userLoginValue", userLoginValue);
			return "login";
		}
		// 密码
		if (StringUtility.isEmptyAfterTrim(userLoginForm.getPassword())) {
			modelMap.put("userLoginValue", userLoginValue);
			return "login";
		}
		UserValue sessionUserValue = getSessionUser(request);
		if (sessionUserValue == null || StringUtility.isEmptyAfterTrim(sessionUserValue.getUserId())) {
			try {
				UserValue userValue = loginService.login(userLoginValue);
				userValue.setPassword(null);
				CookieValue cookieInfo = new CookieValue();
				cookieInfo.setUserId(userValue.getUserId());
				cookieInfo.setPassword(userValue.getCookiePwd());
				// 浏览器添加Cookie
				addCookie(cookieInfo, response);
				// 添加Session
				addSession(userValue, request);
			} catch (Exception e) {
				e.printStackTrace();
				modelMap.put("userLoginValue", userLoginValue);
				modelMap.put("errorMsg", e.getMessage());
				return "login";
			}
		}
		return "redirect:" + "/index";
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, String userId) throws Exception {
		// 刪除Session用户信息
		removeSession(request);
		// 清除Cookie
		removeCookie(response);
		try {
			loginService.deleteLogin(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + "/login";
	}
}
