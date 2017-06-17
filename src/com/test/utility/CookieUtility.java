/**
 * 2017年3月21日 上午11:00:02
 */
package com.test.utility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.test.model.value.CookieValue;

/**
 * @author Esion
 *
 */
public class CookieUtility {
	/**
	 * 创建Cookie
	 * 
	 * @param cookieValue
	 * @param saveCookie
	 * @return cookie
	 */
	public Cookie createCookie(CookieValue cookieValue, boolean saveCookie) {
		Cookie cookie = new Cookie(CookieValue.getCookieName(), cookieValue.getUserId() + "|" + cookieValue.getPassword());
		cookie.setPath("/");
		if (saveCookie) {
			cookie.setMaxAge(7 * 24 * 60 * 60);// Cookie保存一周
		} else {
			cookie.setMaxAge(-1);// 浏览器关闭,Cookie失效
		}
		return cookie;
	}

	/**
	 * 获取Cookie
	 * 
	 * @param request
	 * @return cookieValue
	 */
	public CookieValue getCookie(HttpServletRequest request) {
		CookieValue cookieValue = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(CookieValue.getCookieName())) {
					String value = cookie.getValue();
					if (!StringUtility.isEmptyAfterTrim(value)) {
						String[] split = value.split("|");
						String userId = split[0];
						String password = split[1];
						if (StringUtility.isEmptyAfterTrim(userId) && StringUtility.isEmptyAfterTrim(password)) {
							cookieValue = new CookieValue();
							cookieValue.setUserId(userId);
							cookieValue.setPassword(password);
						}
					}
					break;
				}
			}
		}
		return cookieValue;
	}

	/**
	 * 删除Cookie
	 * 
	 * @return cookie
	 */
	public Cookie removeCookie() {
		Cookie cookie = new Cookie(CookieValue.getCookieName(), null);
		cookie.setMaxAge(0);// 删除该Cookie
		cookie.setPath("/");
		return cookie;
	}

}
