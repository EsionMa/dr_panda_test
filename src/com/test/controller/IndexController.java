/**
 * 2017年2月25日 下午11:58:20
 */
package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.value.user.UserValue;
import com.test.utility.StringUtility;

/**
 * @author Esion
 *
 */
@Controller
public class IndexController extends CommonController {
	@RequestMapping("index")
	public String showIndex(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		autoLogin(request, response);
		// 检测登录
		UserValue sessionUserValue = getSessionUser(request);
		if (sessionUserValue == null || StringUtility.isEmptyAfterTrim(sessionUserValue.getUserId())) {
			return "redirect:" + "/login";
		}
		modelMap.put("userId", sessionUserValue.getUserId());
		return "index";
	}
}
