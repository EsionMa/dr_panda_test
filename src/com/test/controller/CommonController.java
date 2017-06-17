/**
 * 2017年1月15日 下午2:40:19
 */
package com.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.constants.Constants;
import com.test.constants.MsgConstants;
import com.test.model.value.CookieValue;
import com.test.model.value.UserLoginValue;
import com.test.model.value.user.UserValue;
import com.test.service.ILoginService;
import com.test.utility.CookieUtility;
import com.test.utility.StringUtility;

/**
 * @author Esion
 *
 */
public class CommonController {
	private CookieUtility cookieUtility = new CookieUtility();
	@Autowired
	ILoginService loginService;

	protected void autoLogin(HttpServletRequest request, HttpServletResponse response) {
		// Cookie信息
		CookieValue cookieValue = cookieUtility.getCookie(request);
		// Session用户信息
		UserValue sessionUserValue = getSessionUser(request);
		if (cookieValue != null) {
			if (sessionUserValue == null || !sessionUserValue.getUserId().equals(cookieValue.getUserId()) || !sessionUserValue.getCookiePwd().equals(cookieValue.getPassword())) {
				try {
					// 登录信息
					UserLoginValue userLoginValue = new UserLoginValue();
					userLoginValue.setUserId(cookieValue.getUserId());
					userLoginValue.setCookiePwd(cookieValue.getPassword());
					UserValue userValue = loginService.login(userLoginValue);
					if (!StringUtility.isEmptyAfterTrim(userValue.getUserId())) {
						// 保存Cookie
						cookieValue = new CookieValue();
						cookieValue.setUserId(userValue.getUserId());
						cookieValue.setPassword(userValue.getCookiePwd());
						// 浏览器添加Cookie
						addCookie(cookieValue, response);
						userValue.setPassword(null);
						// 添加Session
						addSession(userValue, request);
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 设置json的response
	 * 
	 * @param request
	 * @param response
	 */
	protected void setResponseForJson(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("JSESSIONID", request.getSession().getId());
	}

	/**
	 * 返回json数据
	 * 
	 * @param jsonResult
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResult(String jsonResult, HttpServletResponse response) throws IOException {
		response.getWriter().write(jsonResult);
	}

	/**
	 * 返回json数据
	 * 
	 * @param dataMap
	 * @param resultCode
	 * @param msg
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResult(Map<String, Object> dataMap, int resultCode, String msg, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put(MsgConstants.RETURN_CODE, resultCode);
		resultMap.put(MsgConstants.MESSAGE, msg);
		resultMap.put(MsgConstants.DATA, dataMap);
		resultMap.put(MsgConstants.JSESSIONID, request.getSession().getId());
		String jsonResult = mapper.writeValueAsString(resultMap);
		response.getWriter().write(jsonResult);
	}

	/**
	 * 返回json数据（值）
	 * 
	 * @param dataMap
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForData(Map<String, Object> dataMap, HttpServletRequest request, HttpServletResponse response) throws IOException {
		postJsonResult(dataMap, 200, "", request, response);
	}

	/**
	 * 返回json数据（成功）
	 * 
	 * @param dataMap
	 * @param resultCode
	 * @param msg
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForSuccess(String msg, HttpServletRequest request, HttpServletResponse response) throws IOException {
		postJsonResult(null, 200, msg, request, response);
	}

	protected void postJsonResultForLoginInvalid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		postJsonResult(null, 401, "登录已失效，请重新登录！", request, response);
	}

	/**
	 * 返回json数据（失败）
	 * 
	 * @param dataMap
	 * @param msg
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForFailure(String msg, HttpServletRequest request, HttpServletResponse response) throws IOException {
		postJsonResult(null, 500, msg, request, response);
	}

	/**
	 * 返回json数据（错误）
	 * 
	 * @param dataMap
	 * @param msg
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void postJsonResultForError(String msg, HttpServletRequest request, HttpServletResponse response) throws IOException {
		postJsonResult(null, 400, msg, request, response);
	}

	/**
	 * 添加Cookie
	 * 
	 * @param cookieInfo
	 * @param response
	 */
	protected void addCookie(CookieValue cookieInfo, HttpServletResponse response) {
		Cookie cookie = cookieUtility.createCookie(cookieInfo, false);
		response.addCookie(cookie);
	}

	protected void removeCookie(HttpServletResponse response) {
		Cookie cookie = cookieUtility.removeCookie();
		response.addCookie(cookie);
	}

	/**
	 * 取得Session用户信息
	 * 
	 * @param request
	 * @return userInfo
	 */
	protected UserValue getSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 取得SESSION用户信息
		UserValue userValue = (UserValue) session.getAttribute(Constants.SESSION_USER_VALUE);
		if (userValue == null) {
			userValue = new UserValue();
		}
		return userValue;
	}

	/**
	 * 添加用户信息到Session
	 * 
	 * @param userInfo
	 * @param request
	 */
	protected void addSession(UserValue userValue, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(Constants.SESSION_USER_VALUE, userValue);
	}

	/**
	 * 从Session中删除用户信息
	 * 
	 * @param request
	 */
	protected void removeSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(Constants.SESSION_USER_VALUE, null);
	}

}
